package by.yarik.test_belarusbank.domain.atm;

import java.util.List;

import by.yarik.test_belarusbank.domain.IInteractor;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;
import io.reactivex.Single;

public interface IAtmInteractor extends IInteractor {

    Single<List<AtmViewModel>> atm(String city, String types, boolean withError);
}
