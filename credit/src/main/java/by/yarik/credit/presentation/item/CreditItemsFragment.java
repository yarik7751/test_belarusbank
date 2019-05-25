package by.yarik.credit.presentation.item;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import by.yarik.core.core.baseview.BaseFragment;
import by.yarik.credit.R;
import by.yarik.credit.presentation.adapter.CreditListAdapter;
import by.yarik.credit.presentation.viewmodel.CreditSection;
import by.yarik.credit.presentation.viewmodel.CreditViewModel;

public class CreditItemsFragment extends BaseFragment<ICreditItemsPresenter> implements ICreditItemsView {

    public static final String ARGS_CREDITS = "ARGS_CREDITS";
    protected RecyclerView creditItemsRecyclerView;

    @InjectPresenter
    public CreditItemsPresenter presenter;

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
        initFields(view);
        getPresenter().onCreateView();
        return view;
    }

    private void initFields(View view) {
        creditItemsRecyclerView = view.findViewById(R.id.rv_credit_items);
    }

    @Override
    @ProvidePresenter
    public CreditItemsPresenter initPresenter() {
        CreditSection section = getArguments().getParcelable(ARGS_CREDITS);
        return new CreditItemsPresenter(resourceManager, section);
    }

    @Override
    protected ICreditItemsPresenter getPresenter() {
        return presenter;
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
