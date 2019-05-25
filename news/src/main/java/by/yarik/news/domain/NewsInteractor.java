package by.yarik.news.domain;

import java.util.List;

import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import by.yarik.core.core.basedomain.BaseInteractor;
import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.core.core.rx.ScheduleSingle;
import io.reactivex.Single;

public class NewsInteractor extends BaseInteractor implements INewsInteractor {

    public NewsInteractor(INetworkRepository repository) {
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
