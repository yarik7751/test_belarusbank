package by.yarik.test_belarusbank.screens.news;

import java.util.List;

import by.yarik.test_belarusbank.api.IApi;
import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.core.mappers.NewsMapper;
import by.yarik.test_belarusbank.core.rx.RxTransformers;
import by.yarik.test_belarusbank.core.rx.ScheduleSingle;
import by.yarik.test_belarusbank.screens.news.model.RateViewMoodel;

public class NewsPresenter extends BasePresenter<INewsView> implements INewsPresenter {

    private IApi request;

    public NewsPresenter(INewsView view, ResourceManager resourceManager, IApi request) {
        super(view, resourceManager);
        this.request = request;
    }

    @Override
    public void onCreateView() {
        getView().initUi();
    }

    @Override
    public void onViewCreated() {
        getNews();
    }

    //----------Request-------------
    private void getNews() {
        addDisposable(request.news()
                .flatMap(newsResponses -> {
                    getNewsSuccessful(newsResponses);
                    return request.currencyExchange();
                })
                .compose(ScheduleSingle.io())
                .compose(RxTransformers.applySingleBeforeAndAfter(rxShowLoading(), rxHideLoading()))
                .subscribe(this::getCurrencyExchangeSuccessful, this::onFailure));
    }

    private void getNewsSuccessful(List<NewsResponse> response) {
        addDisposable(NewsMapper.mappingNewsViewModelItems(response)
                .subscribe(viewModels -> getView().updateNews(viewModels), this::onFailure));
    }

    private void getCurrencyExchangeSuccessful(List<CurrencyExchangeResponse> currencyExchangeResponses) {
        addDisposable(NewsMapper.mappingRateViewMoodelItems(resourceManager, currencyExchangeResponses)
                .subscribe(viewMoodels -> {
                    int currentNumber = 0;
                    RateViewMoodel currentRate = viewMoodels.get(currentNumber);
                    getView().updateRate(currentRate);
                }, this::onFailure));
    }
}
