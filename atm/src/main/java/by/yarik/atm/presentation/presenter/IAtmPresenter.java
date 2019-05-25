package by.yarik.atm.presentation.presenter;

import by.yarik.core.core.basepresenter.IBasePresenter;

public interface IAtmPresenter extends IBasePresenter {

    void onCityChange(String city);

    void onBynChange(boolean checked);

    void onUsdChange(boolean checked);

    void onEurChange(boolean checked);

    void onFindAtmClick();

    void onMapReady();
}
