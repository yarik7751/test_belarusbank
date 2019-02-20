package by.yarik.test_belarusbank.data.credits;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.data.BaseRepository;
import by.yarik.test_belarusbank.domain.credits.ICreditsRepository;
import io.reactivex.Single;

public class CreditsRepository extends BaseRepository implements ICreditsRepository {

    public CreditsRepository(Requests requests) {
        super(requests);
    }

    @Override
    public Single<CreditResponse> credits(String types) {
        return requests.credits(types);
    }
}
