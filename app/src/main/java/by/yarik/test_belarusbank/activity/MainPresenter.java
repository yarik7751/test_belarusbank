package by.yarik.test_belarusbank.activity;

import android.os.Bundle;

import by.yarik.core.core.annotations.MainBottomMenuPage;

public class MainPresenter implements IMainPresenter {

    private IMainView view;

    MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        view.initUi();
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        switch (position) {
            case MainBottomMenuPage.NEWS:
                view.setNewsFragment();
                return true;

            case MainBottomMenuPage.CREDITS:
                //view.setCreditsFragment();
                return true;

            case MainBottomMenuPage.ATM:
                view.setAtmFragment();
                return true;
        }
        return false;
    }
}
