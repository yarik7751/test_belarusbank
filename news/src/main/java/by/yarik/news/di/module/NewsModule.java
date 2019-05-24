package by.yarik.news.di.module;

import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.news.domain.INewsInteractor;
import by.yarik.news.domain.NewsInteractor;
import by.yarik.news.start.NewsStarterImpl;
import by.yarik.news_api.INewsStarter;
import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    @Provides
    public INewsInteractor provideNewsInteractor(INetworkRepository networkRepository) {
        return new NewsInteractor(networkRepository);
    }

    @Provides
    public INewsStarter provideNewsStarter() {
        return new NewsStarterImpl();
    }
}
