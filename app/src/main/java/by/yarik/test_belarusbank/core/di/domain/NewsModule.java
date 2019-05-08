package by.yarik.test_belarusbank.core.di.domain;

import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.news.INewsInteractor;
import by.yarik.test_belarusbank.domain.news.NewsInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    @Provides
    public INewsInteractor provideNewsInteractor(INetworkRepository networkRepository) {
        return new NewsInteractor(networkRepository);
    }
}
