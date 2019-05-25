package by.yarik.credit.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import by.yarik.core.core.ResourceManager;
import by.yarik.core.core.annotations.credit.CreditType;
import by.yarik.core.core.annotations.credit.CreditViewModelType;
import by.yarik.core.core.basepresenter.BasePresenter;
import by.yarik.core.core.models.CreditModel;
import by.yarik.core.core.rx.RxTransformers;
import by.yarik.credit.di.CreditApiComponent;
import by.yarik.credit.domain.ICreditsInteractor;
import by.yarik.credit.mapper.CreditsViewModelMapper;
import by.yarik.credit.presentation.view.ICreditsView;
import by.yarik.credit.presentation.viewmodel.CreditSection;
import by.yarik.credit.presentation.viewmodel.CreditViewModel;

@InjectViewState
public class CreditsPresenter extends BasePresenter<ICreditsView> implements ICreditsPresenter {

    private static final String ALL_CREDIT_TYPES = "потребительский,автокредитование,на образование,на недвижимость";

    @Inject
    ICreditsInteractor interactor;

    public CreditsPresenter(ResourceManager resourceManager) {
        super(resourceManager);
        CreditApiComponent.getInstance().inject(this);
    }

    @Override
    public void onCreateView() {
        getView().initUi();
    }

    @Override
    public void onViewCreated() {
        getCredits();
    }

    private void getCredits() {
        addDisposable(interactor.credits(ALL_CREDIT_TYPES)
                .compose(RxTransformers.applySingleBeforeAndAfter(rxShowLoading(), rxHideLoading()))
                .subscribe(this::creditsSuccessful, this::onFailure));
    }

    private void creditsSuccessful(List<CreditModel> models) {
        List<CreditViewModel> viewModels = CreditsViewModelMapper.mappingCreditViewModelItems(resourceManager, models);

        List<CreditViewModel> consumer = getCreditsByType(viewModels, CreditViewModelType.CONSUMER);
        List<CreditViewModel> car = getCreditsByType(viewModels, CreditViewModelType.CAR);
        List<CreditViewModel> education = getCreditsByType(viewModels, CreditViewModelType.EDUCATION);
        List<CreditViewModel> property = getCreditsByType(viewModels, CreditViewModelType.PROPERTY);

        List<CreditSection> sections = Arrays.asList(
                new CreditSection(CreditType.CONSUMER, consumer),
                new CreditSection(CreditType.CAR, car),
                new CreditSection(CreditType.EDUCATION, education),
                new CreditSection(CreditType.PROPERTY, property)
        );
        getView().updateCredits(sections);
    }

    private List<CreditViewModel> getCreditsByType(List<CreditViewModel> viewModels, @CreditViewModelType int type) {
        List<CreditViewModel> result = new ArrayList<>();
        for(CreditViewModel viewModel : viewModels) {
            if(viewModel.getType() == type) {
                result.add(viewModel);
            }
        }
        return result;
    }
}
