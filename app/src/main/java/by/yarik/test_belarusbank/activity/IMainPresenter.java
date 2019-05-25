package by.yarik.test_belarusbank.activity;

import android.os.Bundle;

public interface IMainPresenter {

    void onCreate(Bundle savedInstanceState);

    boolean onTabSelected(int position, boolean wasSelected);
}
