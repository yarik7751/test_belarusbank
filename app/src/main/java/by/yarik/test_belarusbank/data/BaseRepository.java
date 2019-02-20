package by.yarik.test_belarusbank.data;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.domain.IRepository;

public class BaseRepository implements IRepository {

    protected Requests requests;

    public BaseRepository(Requests requests) {
        this.requests = requests;
    }
}
