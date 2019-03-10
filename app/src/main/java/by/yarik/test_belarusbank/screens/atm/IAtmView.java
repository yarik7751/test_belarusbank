package by.yarik.test_belarusbank.screens.atm;

import java.util.List;

import by.yarik.test_belarusbank.core.baseview.IBaseView;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;

public interface IAtmView extends IBaseView {

    void initUi();

    void updateAtms(List<AtmViewModel> viewModels);
}
