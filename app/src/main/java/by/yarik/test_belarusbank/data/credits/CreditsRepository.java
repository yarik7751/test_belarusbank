package by.yarik.test_belarusbank.data.credits;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.core.mappers.credits.CreditsModelMapper;
import by.yarik.test_belarusbank.data.BaseRepository;
import by.yarik.test_belarusbank.domain.credits.ICreditsRepository;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import io.reactivex.Single;

public class CreditsRepository extends BaseRepository implements ICreditsRepository {

    public CreditsRepository(Requests requests) {
        super(requests);
    }

    @Override
    public Single<List<CreditModel>> credits(String types) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", types);

        return requests.credits(data).map(CreditsModelMapper::mappingCreditModelItems);
    }
}
