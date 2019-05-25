package by.yarik.test_belarusbank.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import by.yarik.atm.di.AtmApiComponent;
import by.yarik.core.core.BaseActivity;
import by.yarik.credit.di.CreditApiComponent;
import by.yarik.news.di.NewsApiComponent;
import by.yarik.test_belarusbank.R;

public class MainActivity extends BaseActivity implements IMainView {

    private static final int FIRST_ITEM = 0;
    protected AHBottomNavigation bottomNavigation;

    private IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContainerFragmentRes(R.id.container);
        presenter = new MainPresenter(this);

        presenter.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            setNewsFragment();
        }
    }

    @Override
    public void initUi() {
        initBottomNavigation();
        for(AHBottomNavigationItem item : getBottomItems()) {
            bottomNavigation.addItem(item);
        }
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                return presenter.onTabSelected(position, wasSelected);
            }
        });
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
    public void setNewsFragment() {
        setMainFragment(NewsApiComponent.getInstance().newsStarter().getScreen());
    }

    @Override
    public void setCreditsFragment() {
        setMainFragment(CreditApiComponent.getInstance().creditStarter().getScreen());
    }

    @Override
    public void setAtmFragment() {
        setMainFragment(AtmApiComponent.getInstance().atmStarter().getScreen());
    }
}
