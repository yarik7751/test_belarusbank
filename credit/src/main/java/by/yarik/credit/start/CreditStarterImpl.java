package by.yarik.credit.start;

import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.yarik.credit.presentation.view.CreditsFragment;
import by.yarik.credit_api.ICreditStarter;

public class CreditStarterImpl implements ICreditStarter {

    @Inject
    public CreditStarterImpl() {
    }

    @Override
    public Fragment getScreen() {
        return CreditsFragment.newInstance();
    }
}
