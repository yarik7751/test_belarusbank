package by.yarik.atm.domain;

import java.util.List;

import by.yarik.atm.viewmodel.AtmViewModel;
import by.yarik.core.core.basedomain.IInteractor;
import io.reactivex.Single;

public interface IAtmInteractor extends IInteractor {

    Single<List<AtmViewModel>> atm(String city, String types, boolean withError);
}
