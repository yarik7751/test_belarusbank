package by.yarik.test_belarusbank.screens.atm;

import java.util.List;

import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.core.basepresenter.IBasePresenter;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.core.rx.RxTransformers;
import by.yarik.test_belarusbank.domain.atm.IAtmInteractor;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;

public class AtmPresenter extends BasePresenter<IAtmView> implements IAtmPresenter {

    private static final String TEST_CITY = "Минск";
    private static final String TEST_TYPES = "BYN,USD,EUR";

    private IAtmInteractor interactor;

    public AtmPresenter(IAtmView view, ResourceManager resourceManager, IAtmInteractor interactor) {
        super(view, resourceManager);
        this.interactor = interactor;
    }

    @Override
    public void onCreateView() {
        getView().initUi();
    }

    @Override
    public void onViewCreated() {
    }

    @Override
    public void onMapReady() {
        getAtmByCity();
    }

    private void getAtmByCity() {
        addDisposable(interactor.atm(TEST_CITY, TEST_TYPES, true)
                .compose(RxTransformers.applySingleBeforeAndAfter(rxShowLoading(), rxHideLoading()))
                .subscribe(this::getAtmByCitySuccessful, this::onFailure));
    }

    private void getAtmByCitySuccessful(List<AtmViewModel> viewModels) {
        getView().updateAtms(viewModels);
    }
}
