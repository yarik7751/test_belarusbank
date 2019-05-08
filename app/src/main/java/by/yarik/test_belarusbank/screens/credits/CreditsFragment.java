package by.yarik.test_belarusbank.screens.credits;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.data.NetworkRepository;
import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.credits.CreditsInteractor;
import by.yarik.test_belarusbank.domain.credits.ICreditsInteractor;
import by.yarik.test_belarusbank.screens.credits.adapter.CreditViewPagerAdapter;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;
import by.yarik.test_belarusbank.screens.news.NewsPresenter;

public class CreditsFragment extends BaseFragment<ICreditsPresenter> implements ICreditsView {

    @BindView(R.id.tl_credits_titles)
    protected TabLayout creditsTitles;

    @BindView(R.id.vp_credits)
    protected ViewPager creditsViewPager;

    @InjectPresenter
    public CreditsPresenter presenter;

    public static CreditsFragment newInstance() {
        return new CreditsFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_credits;
    }

    @Override
    @ProvidePresenter
    public CreditsPresenter initPresenter() {
        return new CreditsPresenter(resourceManager);
    }

    @Override
    protected ICreditsPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        getPresenter().onCreateView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initUi() {

    }

    @Override
    public void updateCredits(List<CreditSection> sections) {
        updateCreditsTitles(sections);
        updateCreditsLists(sections);
    }

    private void updateCreditsTitles(List<CreditSection> sections) {
        creditsTitles.setupWithViewPager(creditsViewPager);
        for (CreditSection section : sections) {
            creditsTitles.addTab(creditsTitles.newTab().setText(section.getSectionTitle()));
        }
        creditsTitles.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void updateCreditsLists(List<CreditSection> sections) {
        CreditViewPagerAdapter adapter = new CreditViewPagerAdapter(getChildFragmentManager(), sections);
        creditsViewPager.setAdapter(adapter);
    }
}
