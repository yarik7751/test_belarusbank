package by.yarik.test_belarusbank.domain.news;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.domain.IRepository;
import io.reactivex.Single;

public interface INewsRepository extends IRepository {

    Single<List<NewsResponse>> news();

    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
