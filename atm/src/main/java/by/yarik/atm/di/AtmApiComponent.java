package by.yarik.atm.di;

import javax.inject.Singleton;

import by.yarik.atm.di.model.AtmModule;
import by.yarik.atm.presentation.presenter.AtmPresenter;
import by.yarik.atm_api.IAtmApi;
import by.yarik.core.core.di.data.RepositoryModule;
import by.yarik.core.core.di.data.RequestModule;
import dagger.Component;

@Component(modules = {RequestModule.class, RepositoryModule.class,
        AtmModule.class})
@Singleton
public abstract class AtmApiComponent implements IAtmApi {

    private static AtmApiComponent atmApiComponent;

    public static void init(AtmApiComponent component) {
        atmApiComponent = component;
    }

    public static AtmApiComponent getInstance() {
        return atmApiComponent;
    }

    public abstract void inject(AtmPresenter presenter);
}
