package by.yarik.test_belarusbank.domain.credits;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.domain.IInteractor;
import io.reactivex.Single;

public interface ICreditsInteractor extends IInteractor {

    Single<CreditResponse> credits(String types);
}
