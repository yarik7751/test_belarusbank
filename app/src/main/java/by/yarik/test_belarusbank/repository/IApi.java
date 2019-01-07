package by.yarik.test_belarusbank.repository;

import java.util.List;

import by.yarik.test_belarusbank.repository.pojo.NewsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface IApi {

    @GET(ApiPaths.NEWS)
    Single<List<NewsResponse>> news();
}
