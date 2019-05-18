package by.yarik.news.mapper;
import java.util.List;
import by.yarik.core.api.pojo.CurrencyExchangeResponse;
import by.yarik.core.api.pojo.NewsResponse;
import by.yarik.core.core.ResourceManager;
import by.yarik.news.R;
import by.yarik.news.presentation.news.model.NewsViewModel;
import by.yarik.news.presentation.news.model.RateViewMoodel;
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

    public static Observable<List<RateViewMoodel>> mappingRateViewMoodelItems(ResourceManager resourceManager, List<CurrencyExchangeResponse> responses) {
        return Observable.fromIterable(responses)
                .map(applyRateMapper(resourceManager))
                .toList()
                .toObservable();
    }

    private static Function<CurrencyExchangeResponse, RateViewMoodel> applyRateMapper(ResourceManager resourceManager) {
        return response -> {
            String dateValue = response.getKursDate() + response.getKursDateTime();
            String date = resourceManager.getString(R.string.date_value, dateValue);
            String usdIn = resourceManager.getString(R.string.in_value, response.getUsdCardIn());
            String usdOut = resourceManager.getString(R.string.out_value, response.getUsdCardOut());
            String eurIn = resourceManager.getString(R.string.in_value, response.getEurCardIn());
            String eurOut = resourceManager.getString(R.string.out_value, response.getEurCardOut());

            return new RateViewMoodel(date, usdIn, usdOut, eurIn, eurOut);
        };
    }
}
