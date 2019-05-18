package by.yarik.core.core.di.data;

import by.yarik.core.api.Requests;
import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.core.data.NetworkRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public INetworkRepository provideNetworkRepository(Requests requests) {
        return new NetworkRepository(requests);
    }
}
