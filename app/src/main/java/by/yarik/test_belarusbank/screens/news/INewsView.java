package by.yarik.test_belarusbank.screens.news;

import java.util.List;

import by.yarik.test_belarusbank.core.baseview.IBaseView;
import by.yarik.test_belarusbank.screens.news.model.NewsViewModel;
import by.yarik.test_belarusbank.screens.news.model.RateViewMoodel;

public interface INewsView extends IBaseView {

    void initUi();

    void updateNews(List<NewsViewModel> newsList);

    void updateRate(RateViewMoodel rateViewMoodel);
}
