package by.yarik.test_belarusbank.core.domain.news;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.domain.IInteractor;
import io.reactivex.Single;

public interface INewsInteractor extends IInteractor {

    Single<List<NewsResponse>> news();

    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
