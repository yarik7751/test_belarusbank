package by.yarik.test_belarusbank.screens.credits.item;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.screens.credits.ICreditsView;
import by.yarik.test_belarusbank.screens.credits.adapter.CreditListAdapter;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditViewModel;

public class CreditItemsFragment extends BaseFragment<ICreditItemsPresenter> implements ICreditItemsView {

    public static final String ARGS_CREDITS = "ARGS_CREDITS";

    @BindView(R.id.rv_credit_items)
    protected RecyclerView creditItemsRecyclerView;

    public static CreditItemsFragment newInstance(CreditSection section) {
        Bundle args = new Bundle();
        args.putParcelable(ARGS_CREDITS, section);

        CreditItemsFragment fragment = new CreditItemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_credit_items;
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        getPresenter().onCreateView();
        return view;
    }

    @Override
    protected void setPresenter() {
        CreditSection section = getArguments().getParcelable(ARGS_CREDITS);
        presenter = new CreditItemsPresenter(this, resourceManager, section);
    }

    @Override
    public void initUi() {
        creditItemsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void updateCredits(List<CreditViewModel> creditViewModels) {
        creditItemsRecyclerView.setAdapter(new CreditListAdapter(creditViewModels));
    }
}