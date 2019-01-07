package by.yarik.test_belarusbank.activity;

import android.os.Bundle;

import by.yarik.test_belarusbank.core.BaseActivity;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.screens.news.NewsFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            setNewsFragment();
        }
    }

    public void setNewsFragment() {
        setMainFragment(NewsFragment.newInstance());
    }
}
