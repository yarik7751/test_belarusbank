package by.yarik.news.presentation.news.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import by.yarik.core.core.ResourceManager;
import by.yarik.core.core.basepresenter.BasePresenter;
import by.yarik.news.di.NewsApiComponent;
import by.yarik.news.mapper.NewsMapper;
import by.yarik.core.core.rx.RxTransformers;
import by.yarik.news.domain.INewsInteractor;
import by.yarik.news.presentation.news.model.RateViewMoodel;
import by.yarik.news.presentation.news.view.INewsView;

@InjectViewState
public class NewsPresenter extends BasePresenter<INewsView> implements INewsPresenter {

    @Inject
    INewsInteractor interactor;

    public NewsPresenter(ResourceManager resourceManager) {
        super(resourceManager);
        NewsApiComponent.getInstance().inject(this);
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
