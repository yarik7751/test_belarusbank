package by.yarik.test_belarusbank.domain;

public class BaseInteractor implements IInteractor {

    protected INetworkRepository repository;

    public BaseInteractor(INetworkRepository repository) {
        this.repository = repository;
    }
}
