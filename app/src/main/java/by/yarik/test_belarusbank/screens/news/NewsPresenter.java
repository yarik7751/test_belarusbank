package by.yarik.test_belarusbank.screens.news;

import java.util.List;

import by.yarik.test_belarusbank.api.IApi;
import by.yarik.test_belarusbank.api.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.core.mappers.NewsMapper;
import by.yarik.test_belarusbank.core.rx.RxTransformers;
import by.yarik.test_belarusbank.core.rx.ScheduleSingle;

public class NewsPresenter extends BasePresenter<INewsView> implements INewsPresenter {

    private IApi request;

    public NewsPresenter(INewsView view, IApi request) {
        super(view);
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
                .compose(ScheduleSingle.io())
                .compose(RxTransformers.applySingleBeforeAndAfter(rxShowLoading(), rxHideLoading()))
                .subscribe(this::getNewsSuccessful, this::onFailure));
    }

    private void getNewsSuccessful(List<NewsResponse> response) {
        addDisposable(NewsMapper.mappingNewsViewModelItems(response)
                .subscribe(viewModels -> getView().updateNews(viewModels), this::onFailure));
    }
}
