package by.yarik.atm.di.model;

import by.yarik.atm.domain.AtmInteractor;
import by.yarik.atm.domain.IAtmInteractor;
import by.yarik.atm.starter.AtmStarterImpl;
import by.yarik.atm_api.IAtmApi;
import by.yarik.atm_api.IAtmStarter;
import by.yarik.core.core.basedomain.INetworkRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class AtmModule {

    @Provides
    public IAtmInteractor provideAtmInteractor(INetworkRepository repository) {
        return new AtmInteractor(repository);
    }

    @Provides
    public IAtmStarter provideAtmStarter() {
        return new AtmStarterImpl();
    }
}
