package by.yarik.test_belarusbank.data.news;

import java.util.List;

import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.data.BaseRepository;
import by.yarik.test_belarusbank.domain.news.INewsRepository;
import io.reactivex.Single;

public class NewsRepository extends BaseRepository implements INewsRepository {

    public NewsRepository(Requests requests) {
        super(requests);
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
