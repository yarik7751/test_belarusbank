package by.yarik.credit.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import by.yarik.core.core.baseview.BaseFragment;
import by.yarik.credit.R;
import by.yarik.credit.presentation.adapter.CreditViewPagerAdapter;
import by.yarik.credit.presentation.presenter.CreditsPresenter;
import by.yarik.credit.presentation.presenter.ICreditsPresenter;
import by.yarik.credit.presentation.viewmodel.CreditSection;

public class CreditsFragment extends BaseFragment<ICreditsPresenter> implements ICreditsView {

    protected TabLayout creditsTitles;
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
        initFields(view);
        getPresenter().onCreateView();
        return view;
    }

    private void initFields(View view) {
        creditsTitles = view.findViewById(R.id.tl_credits_titles);
        creditsViewPager = view.findViewById(R.id.vp_credits);
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
