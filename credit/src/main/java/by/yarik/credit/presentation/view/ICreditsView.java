package by.yarik.credit.presentation.view;

import java.util.List;

import by.yarik.core.core.baseview.IBaseView;
import by.yarik.credit.presentation.viewmodel.CreditSection;

public interface ICreditsView extends IBaseView {

    void initUi();

    void updateCredits(List<CreditSection> sections);
}
