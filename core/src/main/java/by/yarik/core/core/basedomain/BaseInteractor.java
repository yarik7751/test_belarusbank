package by.yarik.core.core.basedomain;

public class BaseInteractor implements IInteractor {

    protected INetworkRepository repository;

    public BaseInteractor(INetworkRepository repository) {
        this.repository = repository;
    }
}
