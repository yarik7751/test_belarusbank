package by.yarik.test_belarusbank.screens.news;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import by.yarik.test_belarusbank.BelarusbankApplication;
import by.yarik.test_belarusbank.api.pojo.CurrencyExchangeResponse;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.domain.news.INewsInteractor;
import by.yarik.test_belarusbank.core.mappers.news.NewsMapper;
import by.yarik.test_belarusbank.core.rx.RxTransformers;
import by.yarik.test_belarusbank.screens.news.model.RateViewMoodel;

@InjectViewState
public class NewsPresenter extends BasePresenter<INewsView> implements INewsPresenter {

    @Inject
    INewsInteractor interactor;

    NewsPresenter(ResourceManager resourceManager) {
        super(resourceManager);
        BelarusbankApplication.getApiComponent().inject(this);
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
        addDisposable(interactor.news()
                .flatMap(newsResponses -> {
                    getNewsSuccessful(newsResponses);
                    return interactor.currencyExchange();
                })
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
