package by.yarik.news.domain;

import java.util.List;

import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import by.yarik.core.core.basedomain.IInteractor;
import io.reactivex.Single;

public interface INewsInteractor extends IInteractor {

    Single<List<NewsResponse>> news();

    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
