package by.yarik.core.core.di.data;

import javax.inject.Singleton;

import by.yarik.core.api.Requests;
import by.yarik.core.api.belarusbank.Api;
import by.yarik.core.api.belarusbank.IApi;
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
