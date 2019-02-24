package by.yarik.test_belarusbank.screens.credits.item;

import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;

public class CreditItemsPresenter extends BasePresenter<ICreditItemsView> implements ICreditItemsPresenter{

    private CreditSection section;

    public CreditItemsPresenter(ICreditItemsView view, ResourceManager resourceManager, CreditSection section) {
        super(view, resourceManager);
        this.section = section;
    }

    @Override
    public void onCreateView() {
        getView().initUi();
        getView().updateCredits(section.getCreditViewModels());
    }

    @Override
    public void onViewCreated() {
    }
}
