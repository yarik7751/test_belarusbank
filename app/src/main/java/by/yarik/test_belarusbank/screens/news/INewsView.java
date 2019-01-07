package by.yarik.test_belarusbank.screens.news;

import java.util.List;

import by.yarik.test_belarusbank.repository.pojo.NewsResponse;
import by.yarik.test_belarusbank.core.baseview.IBaseView;
import by.yarik.test_belarusbank.screens.news.model.NewsViewModel;

public interface INewsView extends IBaseView {
    void initUi();

    void updateNews(List<NewsViewModel> newsList);
}
