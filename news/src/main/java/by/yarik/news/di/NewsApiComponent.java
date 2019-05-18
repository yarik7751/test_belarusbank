package by.yarik.news.di;

import javax.inject.Singleton;

import by.yarik.core.core.di.data.RepositoryModule;
import by.yarik.core.core.di.data.RequestModule;
import by.yarik.news.di.module.NewsModule;
import by.yarik.news.presentation.news.presenter.NewsPresenter;
import dagger.Component;

@Component(modules = {RequestModule.class, RepositoryModule.class,
        NewsModule.class})
@Singleton
public abstract class NewsApiComponent {

    private static NewsApiComponent newsApiComponent;

    public static void init(NewsApiComponent component) {
        newsApiComponent = component;
    }

    public static NewsApiComponent getInstance() {
        return newsApiComponent;
    }

    public abstract void inject(NewsPresenter fragment);
}
