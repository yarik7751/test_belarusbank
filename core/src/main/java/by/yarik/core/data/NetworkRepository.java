package by.yarik.core.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.yarik.core.api.Requests;
import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.core.core.mappers.AtmModelMapper;
import by.yarik.core.core.mappers.CreditsModelMapper;
import by.yarik.core.core.models.AtmModel;
import by.yarik.core.core.models.CreditModel;
import io.reactivex.Single;

public class NetworkRepository implements INetworkRepository {

    protected Requests requests;

    public NetworkRepository(Requests requests) {
        this.requests = requests;
    }

    @Override
    public Single<List<AtmModel>> atm(String city, String types) {
        Map<String, Object> data = new HashMap<>();
        data.put("city", city);
        data.put("ATM_currency", types);
        return requests.atm(data).map(AtmModelMapper::mappingAtmModelItems);
    }

    @Override
    public Single<List<CreditModel>> credits(String types) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", types);

        return requests.credits(data).map(CreditsModelMapper::mappingCreditModelItems);
    }

    @Override
    public Single<List<NewsResponse>> news() {
        return requests.news();
    }

    @Override
    public Single<List<CurrencyExchangeResponse>> currencyExchange() {
        return requests.currencyExchange();
    }
}
