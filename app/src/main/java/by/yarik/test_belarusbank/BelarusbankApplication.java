package by.yarik.test_belarusbank;

import android.app.Application;

import by.yarik.test_belarusbank.core.di.ApiComponent;
import by.yarik.test_belarusbank.core.di.DaggerApiComponent;

public class BelarusbankApplication extends Application {

    private static ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder().build();
    }

    public static ApiComponent getApiComponent() {
        return apiComponent;
    }
}
