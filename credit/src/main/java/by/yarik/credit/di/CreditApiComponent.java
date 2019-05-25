package by.yarik.credit.di;

import javax.inject.Singleton;

import by.yarik.core.core.di.data.RepositoryModule;
import by.yarik.core.core.di.data.RequestModule;
import by.yarik.credit.di.module.CreditModule;
import by.yarik.credit.presentation.presenter.CreditsPresenter;
import by.yarik.credit_api.ICreditApi;
import dagger.Component;

@Component(modules = {RequestModule.class, RepositoryModule.class, CreditModule.class})
@Singleton
public abstract class CreditApiComponent implements ICreditApi {

    private static CreditApiComponent creditApiComponent;

    public static void init(CreditApiComponent component) {
        creditApiComponent = component;
    }

    public static CreditApiComponent getInstance() {
        return creditApiComponent;
    }

    public abstract void inject(CreditsPresenter presenter);
}
