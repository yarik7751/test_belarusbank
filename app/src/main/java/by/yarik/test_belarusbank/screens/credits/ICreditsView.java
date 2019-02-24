package by.yarik.test_belarusbank.screens.credits;

import java.util.List;

import by.yarik.test_belarusbank.core.baseview.IBaseView;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditViewModel;

public interface ICreditsView extends IBaseView {

    void initUi();

    void updateCredits(List<CreditSection> sections);
}
