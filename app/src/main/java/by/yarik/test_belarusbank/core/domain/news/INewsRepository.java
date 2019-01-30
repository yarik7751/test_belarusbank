package by.yarik.test_belarusbank.core.domain.news;

import java.util.List;

import by.yarik.test_belarusbank.api.belarusbank.ApiPaths;
import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.domain.IRepository;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface INewsRepository extends IRepository {

    Single<List<NewsResponse>> news();

    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
