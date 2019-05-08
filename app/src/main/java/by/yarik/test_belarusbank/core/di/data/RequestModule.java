package by.yarik.test_belarusbank.core.di.data;

import javax.inject.Singleton;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.api.belarusbank.Api;
import by.yarik.test_belarusbank.api.belarusbank.IApi;
import dagger.Module;
import dagger.Provides;

@Module
public class RequestModule {

    @Provides
    @Singleton
    public Requests provideRequest(IApi api) {
        return new Requests(api);
    }

    @Provides
    @Singleton
    public IApi provideApi() {
        return Api.getBelarusbankApi();
    }
}
