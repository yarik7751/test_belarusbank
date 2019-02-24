package by.yarik.test_belarusbank.domain.credits;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.domain.IRepository;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import io.reactivex.Single;

public interface ICreditsRepository extends IRepository {

    Single<List<CreditModel>> credits(String types);
}
