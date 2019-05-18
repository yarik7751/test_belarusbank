package by.yarik.core.api;

import java.util.List;
import java.util.Map;

import by.yarik.core.api.pojo.CreditResponse;
import by.yarik.core.api.belarusbank.IApi;
import by.yarik.core.api.pojo.AtmResponse;
import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public class Requests {

    private IApi belarusbankApi;

    public Requests(IApi belarusbankApi) {
        this.belarusbankApi = belarusbankApi;
    }

    public Single<List<NewsResponse>> news() {
        return belarusbankApi.news();
    }

    public Single<List<CurrencyExchangeResponse>> currencyExchange() {
        return belarusbankApi.currencyExchange();
    }

    public Single<List<CreditResponse>> credits(Map<String, Object> data) {
        return belarusbankApi.credits(data);
    }

    public Single<List<AtmResponse>> atm(Map<String, Object> data) {
        return belarusbankApi.atm(data);
    }
}
