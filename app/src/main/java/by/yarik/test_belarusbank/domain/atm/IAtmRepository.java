package by.yarik.test_belarusbank.domain.atm;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.AtmResponse;
import by.yarik.test_belarusbank.domain.IRepository;
import by.yarik.test_belarusbank.screens.atm.model.AtmModel;
import io.reactivex.Single;

public interface IAtmRepository extends IRepository {

    Single<List<AtmModel>> atm(String city, String types);
}
