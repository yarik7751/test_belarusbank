package by.yarik.test_belarusbank.screens.credits.item;

import java.util.List;

import by.yarik.core.core.baseview.IBaseView;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditViewModel;

public interface ICreditItemsView extends IBaseView {

    void initUi();

    void updateCredits(List<CreditViewModel> creditViewModels);
}
