package by.yarik.test_belarusbank.screens.credits;

import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.BasePresenter;
import by.yarik.test_belarusbank.core.basepresenter.IBasePresenter;
import by.yarik.test_belarusbank.domain.credits.ICreditsInteractor;

public class CreditsPresenter extends BasePresenter<ICreditsView> implements ICreditsPresenter {

    private ICreditsInteractor interactor;

    public CreditsPresenter(ICreditsView view, ResourceManager resourceManager, ICreditsInteractor interactor) {
        super(view, resourceManager);
        this.interactor = interactor;
    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void onViewCreated() {

    }
}
