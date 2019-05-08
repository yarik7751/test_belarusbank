package by.yarik.test_belarusbank.core.di.domain;

import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.atm.AtmInteractor;
import by.yarik.test_belarusbank.domain.atm.IAtmInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class AtmModule {

    @Provides
    public IAtmInteractor provideAtmInteractor(INetworkRepository repository) {
        return new AtmInteractor(repository);
    }
}
