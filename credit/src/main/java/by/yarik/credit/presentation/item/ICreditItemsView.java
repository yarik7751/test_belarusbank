package by.yarik.credit.presentation.item;

import java.util.List;

import by.yarik.core.core.baseview.IBaseView;
import by.yarik.credit.presentation.viewmodel.CreditViewModel;

public interface ICreditItemsView extends IBaseView {

    void initUi();

    void updateCredits(List<CreditViewModel> creditViewModels);
}
