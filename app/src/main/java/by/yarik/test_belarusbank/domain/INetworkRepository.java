package by.yarik.test_belarusbank.domain;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import by.yarik.test_belarusbank.screens.atm.model.AtmModel;
import io.reactivex.Single;

public interface INetworkRepository {

    Single<List<AtmModel>> atm(String city, String types);

    Single<List<CreditModel>> credits(String types);

    Single<List<NewsResponse>> news();

    Single<List<CurrencyExchangeResponse>> currencyExchange();
}
