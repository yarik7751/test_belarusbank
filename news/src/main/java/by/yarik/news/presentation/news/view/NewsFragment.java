package by.yarik.news.presentation.news.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import by.yarik.core.core.baseview.BaseFragment;
import by.yarik.news.R;
import by.yarik.news.presentation.news.model.NewsViewModel;
import by.yarik.news.presentation.news.model.RateViewMoodel;
import by.yarik.news.presentation.news.presenter.INewsPresenter;
import by.yarik.news.presentation.news.presenter.NewsPresenter;
import by.yarik.news.presentation.news.view.adapter.NewsAdapter;

public class NewsFragment extends BaseFragment<INewsPresenter> implements INewsView {

    protected RecyclerView news;
    protected TextView rateDateTextView;
    protected TextView eurInTextView;
    protected TextView eurOutTextView;
    protected TextView usdInTextView;
    protected TextView usdOutTextView;

    @InjectPresenter
    public NewsPresenter presenter;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        initFields(view);
        getPresenter().onCreateView();
        return view;
    }

    private void initFields(View view) {
        news = view.findViewById(R.id.rv_news);
        rateDateTextView = view.findViewById(R.id.tv_rate_date);
        eurInTextView = view.findViewById(R.id.tv_eur_in);
        eurOutTextView = view.findViewById(R.id.tv_eur_out);
        usdInTextView = view.findViewById(R.id.tv_usd_in);
        usdOutTextView = view.findViewById(R.id.tv_usd_out);
    }

    @Override
    @ProvidePresenter
    public NewsPresenter initPresenter() {
        return new NewsPresenter(resourceManager);
    }

    @Override
    protected INewsPresenter getPresenter() {
        return presenter;
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
