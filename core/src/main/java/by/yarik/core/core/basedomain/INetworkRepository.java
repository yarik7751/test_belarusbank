package by.yarik.core.core.basedomain;

import java.util.List;

import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import by.yarik.core.core.models.AtmModel;
import by.yarik.core.core.models.CreditModel;
import io.reactivex.Single;

public interface INetworkRepository {

    Single<List<AtmModel>> atm(String city, String types);

    Single<List<CreditModel>> credits(String types);

    Single<List<NewsResponse>> news();

    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
