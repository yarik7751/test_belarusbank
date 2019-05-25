package by.yarik.credit.di.module;

import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.credit.domain.CreditsInteractor;
import by.yarik.credit.domain.ICreditsInteractor;
import by.yarik.credit.start.CreditStarterImpl;
import by.yarik.credit_api.ICreditStarter;
import dagger.Module;
import dagger.Provides;

@Module
public class CreditModule {

    @Provides
    public ICreditsInteractor provideCreditsInteractor(INetworkRepository networkRepository) {
        return new CreditsInteractor(networkRepository);
    }

    @Provides
    public ICreditStarter provideStarter() {
        return new CreditStarterImpl();
    }
}
