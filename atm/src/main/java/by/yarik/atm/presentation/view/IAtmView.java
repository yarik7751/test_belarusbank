package by.yarik.atm.presentation.view;

import java.util.List;

import by.yarik.atm.viewmodel.AtmViewModel;
import by.yarik.core.core.baseview.IBaseView;

public interface IAtmView extends IBaseView {

    void initUi();

    void showInfoMessage(String info);

    void updateAtms(List<AtmViewModel> viewModels);
}
