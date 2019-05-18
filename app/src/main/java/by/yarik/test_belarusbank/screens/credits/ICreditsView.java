package by.yarik.test_belarusbank.screens.credits;

import java.util.List;

import by.yarik.core.core.baseview.IBaseView;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;

public interface ICreditsView extends IBaseView {

    void initUi();

    void updateCredits(List<CreditSection> sections);
}
