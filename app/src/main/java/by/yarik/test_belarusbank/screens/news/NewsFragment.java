package by.yarik.test_belarusbank.screens.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.data.news.NewsRepository;
import by.yarik.test_belarusbank.domain.news.INewsInteractor;
import by.yarik.test_belarusbank.domain.news.INewsRepository;
import by.yarik.test_belarusbank.domain.news.NewsInteractor;
import by.yarik.test_belarusbank.screens.news.adapter.NewsAdapter;
import by.yarik.test_belarusbank.screens.news.model.NewsViewModel;
import by.yarik.test_belarusbank.screens.news.model.RateViewMoodel;

public class NewsFragment extends BaseFragment<INewsPresenter> implements INewsView {

    @BindView(R.id.rv_news)
    protected RecyclerView news;

    @BindView(R.id.tv_rate_date)
    protected TextView rateDateTextView;

    @BindView(R.id.tv_eur_in)
    protected TextView eurInTextView;

    @BindView(R.id.tv_eur_out)
    protected TextView eurOutTextView;

    @BindView(R.id.tv_usd_in)
    protected TextView usdInTextView;

    @BindView(R.id.tv_usd_out)
    protected TextView usdOutTextView;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        getPresenter().onCreateView();
        return view;
    }

    @Override
    protected void setPresenter() {
        Requests requests = getRequests();
        INewsRepository repository = new NewsRepository(requests);
        INewsInteractor interactor = new NewsInteractor(repository);
        presenter = new NewsPresenter(this, resourceManager, interactor);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onViewCreated();
    }

    @Override
    public void initUi() {
        news.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void updateNews(List<NewsViewModel> newsList) {
        news.setAdapter(new NewsAdapter(newsList));
    }

    @Override
    public void updateRate(RateViewMoodel rateViewMoodel) {
        rateDateTextView.setText(rateViewMoodel.getDate());
        usdInTextView.setText(rateViewMoodel.getUsdIn());
        usdOutTextView.setText(rateViewMoodel.getUsdOut());
        eurInTextView.setText(rateViewMoodel.getEurIn());
        eurOutTextView.setText(rateViewMoodel.getEurOut());
    }
}
