package by.yarik.test_belarusbank;

import android.app.Application;

import by.yarik.news.di.DaggerNewsApiComponent;
import by.yarik.news.di.NewsApiComponent;

public class BelarusbankApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NewsApiComponent.init(DaggerNewsApiComponent.builder().build());
    }
}
