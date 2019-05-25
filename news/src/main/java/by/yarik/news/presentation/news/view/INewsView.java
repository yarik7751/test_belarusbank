package by.yarik.news.presentation.news.view;

import java.util.List;

import by.yarik.core.core.baseview.IBaseView;
import by.yarik.news.presentation.news.model.NewsViewModel;
import by.yarik.news.presentation.news.model.RateViewMoodel;

public interface INewsView extends IBaseView {

    void initUi();

    void updateNews(List<NewsViewModel> newsList);

    void updateRate(RateViewMoodel rateViewMoodel);
}
