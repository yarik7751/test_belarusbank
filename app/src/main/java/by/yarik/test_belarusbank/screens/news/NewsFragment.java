package by.yarik.test_belarusbank.screens.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.repository.Api;
import by.yarik.test_belarusbank.repository.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.screens.news.adapter.NewsAdapter;
import by.yarik.test_belarusbank.screens.news.model.NewsViewModel;

public class NewsFragment extends BaseFragment<INewsPresenter> implements INewsView {

    @BindView(R.id.rv_news)
    protected RecyclerView news;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public int resourcesLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(View view) {
        presenter = new NewsPresenter(this, Api.getClient(getContext()));
        getPresenter().onCreateView();
        return view;
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
}
