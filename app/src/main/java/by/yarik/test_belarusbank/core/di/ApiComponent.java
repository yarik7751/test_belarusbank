package by.yarik.test_belarusbank.core.di;

import javax.inject.Singleton;

import by.yarik.test_belarusbank.core.di.data.RepositoryModule;
import by.yarik.test_belarusbank.core.di.data.RequestModule;
import by.yarik.test_belarusbank.core.di.domain.AtmModule;
import by.yarik.test_belarusbank.core.di.domain.CreditsModule;
import by.yarik.test_belarusbank.core.di.domain.NewsModule;
import by.yarik.test_belarusbank.screens.atm.AtmPresenter;
import by.yarik.test_belarusbank.screens.credits.CreditsPresenter;
import by.yarik.test_belarusbank.screens.news.NewsPresenter;
import dagger.Component;

@Component(modules = {RequestModule.class, RepositoryModule.class,
        NewsModule.class,
        AtmModule.class,
        CreditsModule.class})
@Singleton
public interface ApiComponent {

    void inject(NewsPresenter fragment);

    void inject(AtmPresenter fragment);

    void inject(CreditsPresenter fragment);
}
