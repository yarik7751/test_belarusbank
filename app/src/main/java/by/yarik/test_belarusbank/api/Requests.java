package by.yarik.test_belarusbank.api;

import java.util.List;

import by.yarik.test_belarusbank.api.belarusbank.ApiPaths;
import by.yarik.test_belarusbank.api.belarusbank.IApi;
import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

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
}
