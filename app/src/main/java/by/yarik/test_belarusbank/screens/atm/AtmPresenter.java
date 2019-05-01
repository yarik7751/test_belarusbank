package by.yarik.test_belarusbank.screens.atm;

import com.arellomobile.mvp.InjectViewState;
import com.google.android.gms.common.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.core.rx.RxTransformers;
import by.yarik.test_belarusbank.domain.atm.IAtmInteractor;
import by.yarik.test_belarusbank.screens.atm.model.AtmParamsModel;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;

@InjectViewState
public class AtmPresenter extends BasePresenter<IAtmView> implements IAtmPresenter {

    private static final String COMMA = ",";

    private static final String DEFAULT_CITY = "Минск";
    private static final String DEFAULT_TYPES = "BYN,USD,EUR";

    private static final String CURRENCY_TYPES_BYN = "BYN";
    private static final String CURRENCY_TYPES_USD = "USD";
    private static final String CURRENCY_TYPES_EUR = "EUR";

    private IAtmInteractor interactor;
    private AtmParamsModel paramsModel;

    AtmPresenter(ResourceManager resourceManager, IAtmInteractor interactor) {
        super(resourceManager);
        this.interactor = interactor;
        paramsModel = new AtmParamsModel();
    }

    @Override
    public void onCityChange(String city) {
        paramsModel.setCity(city);
    }

    @Override
    public void onBynChange(boolean checked) {
        paramsModel.addCurrency(CURRENCY_TYPES_BYN, checked);
    }

    @Override
    public void onUsdChange(boolean checked) {
        paramsModel.addCurrency(CURRENCY_TYPES_USD, checked);
    }

    @Override
    public void onEurChange(boolean checked) {
        paramsModel.addCurrency(CURRENCY_TYPES_EUR, checked);
    }

    @Override
    public void onFindAtmClick() {
        String city = paramsModel.getCity();
        String types = getTypes();

        getAtmByCity(city, types);
    }

    private String getTypes() {
        StringBuilder currenciesValue = new StringBuilder();
        for(HashMap.Entry<String, Boolean> currency : paramsModel.getCurrencies().entrySet()) {
            currenciesValue.append(currency.getKey()).append(COMMA);
        }

        return currenciesValue.substring(0, currenciesValue.length() - 1);
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
        getAtmByCity(DEFAULT_CITY, DEFAULT_TYPES);
    }

    private void getAtmByCity(String city, String types) {
        addDisposable(interactor.atm(city, types, true)
                .compose(RxTransformers.applySingleBeforeAndAfter(rxShowLoading(), rxHideLoading()))
                .subscribe(this::getAtmByCitySuccessful, this::onFailure));
    }

    private void getAtmByCitySuccessful(List<AtmViewModel> viewModels) {
        if(CollectionUtils.isEmpty(viewModels)) {
            getView().showInfoMessage(resourceManager.getString(R.string.atm_empty_message));
        } else {
            getView().updateAtms(viewModels);
        }
    }
}
