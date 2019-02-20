package by.yarik.test_belarusbank.domain;

import by.yarik.test_belarusbank.data.BaseRepository;

public class BaseInteractor<R extends IRepository> implements IInteractor {

    protected R repository;

    public BaseInteractor(R repository) {
        this.repository = repository;
    }
}
