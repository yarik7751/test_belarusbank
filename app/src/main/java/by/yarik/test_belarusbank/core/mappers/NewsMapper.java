package by.yarik.test_belarusbank.core.mappers;


import java.util.List;

import by.yarik.test_belarusbank.repository.pojo.NewsResponse;
import by.yarik.test_belarusbank.screens.news.model.NewsViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class NewsMapper {

    public static Observable<List<NewsViewModel>> mappingNewsViewModelItems(List<NewsResponse> responses) {
        return Observable.fromIterable(responses)
                .map(applyNewsMapper())
                .toList()
                .toObservable();
    }

    private static Function<NewsResponse, NewsViewModel> applyNewsMapper() {
        return newsResponse -> {
            String title = newsResponse.getNameRu();
            String description = newsResponse.getHtmlRu();

            return new NewsViewModel(title, description);
        };
    }
}
