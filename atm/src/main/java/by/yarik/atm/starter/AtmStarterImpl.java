package by.yarik.atm.starter;

import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.yarik.atm.presentation.view.AtmFragment;
import by.yarik.atm_api.IAtmStarter;

public class AtmStarterImpl implements IAtmStarter {

    @Inject
    public AtmStarterImpl() {
    }

    @Override
    public Fragment getScreen() {
        return AtmFragment.newInstance();
    }
}
