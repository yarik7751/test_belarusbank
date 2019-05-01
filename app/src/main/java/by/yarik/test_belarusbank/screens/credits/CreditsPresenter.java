package by.yarik.test_belarusbank.screens.credits;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.annotations.credit.CreditType;
import by.yarik.test_belarusbank.core.annotations.credit.CreditViewModelType;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.core.rx.RxTransformers;
import by.yarik.test_belarusbank.domain.credits.ICreditsInteractor;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditViewModel;

@InjectViewState
public class CreditsPresenter extends BasePresenter<ICreditsView> implements ICreditsPresenter {

    private static final String ALL_CREDIT_TYPES = "потребительский,автокредитование,на образование,на недвижимость";

    private ICreditsInteractor interactor;

    CreditsPresenter(ResourceManager resourceManager, ICreditsInteractor interactor) {
        super(resourceManager);
        this.interactor = interactor;
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

    private void creditsSuccessful(List<CreditViewModel> viewModels) {
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
