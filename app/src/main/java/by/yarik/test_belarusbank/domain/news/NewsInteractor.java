package by.yarik.test_belarusbank.domain.news;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.domain.BaseInteractor;
import by.yarik.test_belarusbank.core.rx.ScheduleSingle;
import io.reactivex.Single;

public class NewsInteractor extends BaseInteractor<INewsRepository> implements INewsInteractor {

    public NewsInteractor(INewsRepository repository) {
        super(repository);
    }

    @Override
    public Single<List<NewsResponse>> news() {
        return repository.news().compose(ScheduleSingle.io());
    }

    @Override
    public Single<List<CurrencyExchangeResponse>> currencyExchange() {
        return repository.currencyExchange().compose(ScheduleSingle.io());
    }
}
