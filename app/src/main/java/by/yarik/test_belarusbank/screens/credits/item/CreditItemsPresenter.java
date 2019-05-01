package by.yarik.test_belarusbank.screens.credits.item;

import com.arellomobile.mvp.InjectViewState;

import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;

@InjectViewState
public class CreditItemsPresenter extends BasePresenter<ICreditItemsView> implements ICreditItemsPresenter{

    private CreditSection section;

    public CreditItemsPresenter(ResourceManager resourceManager, CreditSection section) {
        super(resourceManager);
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
