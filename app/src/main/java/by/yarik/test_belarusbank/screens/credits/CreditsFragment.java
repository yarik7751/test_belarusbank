package by.yarik.test_belarusbank.screens.credits;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.data.credits.CreditsRepository;
import by.yarik.test_belarusbank.domain.credits.CreditsInteractor;
import by.yarik.test_belarusbank.domain.credits.ICreditsInteractor;
import by.yarik.test_belarusbank.domain.credits.ICreditsRepository;

public class CreditsFragment extends BaseFragment<ICreditsPresenter> implements ICreditsView {

    public static CreditsFragment newInstance() {
        return new CreditsFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_credits;
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        return view;
    }

    @Override
    protected void setPresenter() {
        ICreditsRepository repository = new CreditsRepository(requests);
        ICreditsInteractor interactor = new CreditsInteractor(repository);
        presenter = new CreditsPresenter(this, resourceManager, interactor);
    }
}
