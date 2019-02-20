package by.yarik.test_belarusbank.domain.credits;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.domain.IRepository;
import io.reactivex.Single;

public interface ICreditsRepository extends IRepository {

    Single<CreditResponse> credits(String types);
}
