package by.yarik.test_belarusbank.screens.atm;

import by.yarik.test_belarusbank.core.basepresenter.IBasePresenter;

public interface IAtmPresenter extends IBasePresenter {

    void onCityChange(String city);

    void onBynChange(boolean checked);

    void onUsdChange(boolean checked);

    void onEurChange(boolean checked);

    void onFindAtmClick();

    void onMapReady();
}
