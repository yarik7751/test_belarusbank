package by.yarik.test_belarusbank;

import android.app.Application;

import com.arellomobile.mvp.RegisterMoxyReflectorPackages;

import by.yarik.atm.di.AtmApiComponent;
import by.yarik.atm.di.DaggerAtmApiComponent;
import by.yarik.news.di.DaggerNewsApiComponent;
import by.yarik.news.di.NewsApiComponent;

@RegisterMoxyReflectorPackages({"by.yarik.news", "by.yarik.atm"})
public class BelarusbankApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NewsApiComponent.init(DaggerNewsApiComponent.builder().build());
        AtmApiComponent.init(DaggerAtmApiComponent.builder().build());
    }
}
