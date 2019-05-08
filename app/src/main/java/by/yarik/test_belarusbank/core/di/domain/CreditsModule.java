package by.yarik.test_belarusbank.core.di.domain;

import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.credits.CreditsInteractor;
import by.yarik.test_belarusbank.domain.credits.ICreditsInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class CreditsModule {

    @Provides
    public ICreditsInteractor provideCreditsInteractor(INetworkRepository repository) {
        return new CreditsInteractor(repository);
    }
}
