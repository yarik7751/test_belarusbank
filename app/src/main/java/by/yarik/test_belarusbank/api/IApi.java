package by.yarik.test_belarusbank.api;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface IApi {

    @GET(ApiPaths.NEWS)
    Single<List<NewsResponse>> news();

    @GET(ApiPaths.CURRENCY_EXCHANGE_CARDS)
    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
