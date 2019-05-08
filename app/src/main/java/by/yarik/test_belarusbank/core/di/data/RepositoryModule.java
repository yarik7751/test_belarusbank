package by.yarik.test_belarusbank.core.di.data;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.data.NetworkRepository;
import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.news.INewsInteractor;
import by.yarik.test_belarusbank.domain.news.NewsInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public INetworkRepository provideNetworkRepository(Requests requests) {
        return new NetworkRepository(requests);
    }
}
