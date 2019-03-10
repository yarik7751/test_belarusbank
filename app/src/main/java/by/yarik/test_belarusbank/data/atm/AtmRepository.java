package by.yarik.test_belarusbank.data.atm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.api.pojo.AtmResponse;
import by.yarik.test_belarusbank.core.mappers.atm.AtmModelMapper;
import by.yarik.test_belarusbank.data.BaseRepository;
import by.yarik.test_belarusbank.domain.atm.IAtmRepository;
import by.yarik.test_belarusbank.screens.atm.model.AtmModel;
import io.reactivex.Single;

public class AtmRepository extends BaseRepository implements IAtmRepository {

    public AtmRepository(Requests requests) {
        super(requests);
    }

    @Override
    public Single<List<AtmModel>> atm(String city, String types) {
        Map<String, Object> data = new HashMap<>();
        data.put("city", city);
        data.put("ATM_currency", types);
        return requests.atm(data).map(AtmModelMapper::mappingAtmModelItems);
    }
}
