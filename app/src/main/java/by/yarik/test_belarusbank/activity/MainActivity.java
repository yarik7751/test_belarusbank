package by.yarik.test_belarusbank.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import by.yarik.core.core.BaseActivity;
import by.yarik.core.core.annotations.MainBottomMenuPage;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.screens.atm.AtmFragment;
import by.yarik.test_belarusbank.screens.credits.CreditsFragment;
import by.yarik.news.presentation.news.view.NewsFragment;

public class MainActivity extends BaseActivity implements AHBottomNavigation.OnTabSelectedListener {

    private static final int FIRST_ITEM = 0;
    protected AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContainerFragmentRes(R.id.container);
        initBottomNavigation();
        for(AHBottomNavigationItem item : getBottomItems()) {
            bottomNavigation.addItem(item);
        }

        if (savedInstanceState == null) {
            setNewsFragment();
        }
    }

    private void initBottomNavigation() {
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setUseElevation(true);
        bottomNavigation.setDefaultBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
        bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setAccentColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
        bottomNavigation.setInactiveColor(ContextCompat.getColor(this, android.R.color.holo_green_light));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setColored(false);
        bottomNavigation.setCurrentItem(FIRST_ITEM);
        bottomNavigation.setOnTabSelectedListener(this);
        bottomNavigation.setTitleTextSizeInSp(14, 12);
    }

    private List<AHBottomNavigationItem> getBottomItems() {
        List<AHBottomNavigationItem> items = new ArrayList<>();
        items.add(new AHBottomNavigationItem(R.string.news_title, R.drawable.ic_news, R.color.colorPrimary));
        items.add(new AHBottomNavigationItem(R.string.credits_title, R.drawable.ic_credits, R.color.colorPrimary));
        items.add(new AHBottomNavigationItem(R.string.atm_title, R.drawable.ic_atm, R.color.colorPrimary));
        return items;
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        switch (position) {
            case MainBottomMenuPage.NEWS:
                setNewsFragment();
                return true;

            case MainBottomMenuPage.CREDITS:
                setCreditsFragment();
                return true;

            case MainBottomMenuPage.ATM:
                setAtmFragment();
                return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    public void setNewsFragment() {
        setMainFragment(NewsFragment.newInstance());
    }

    public void setCreditsFragment() {
        //setMainFragment(CreditsFragment.newInstance());
    }

    public void setAtmFragment() {
        //setMainFragment(AtmFragment.newInstance());
    }
}
