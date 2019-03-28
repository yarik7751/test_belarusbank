package by.yarik.test_belarusbank.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.mappers.atm.AtmModelMapper;
import by.yarik.test_belarusbank.core.mappers.credits.CreditsModelMapper;
import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import by.yarik.test_belarusbank.screens.atm.model.AtmModel;
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
