package by.yarik.test_belarusbank.core.baseview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.api.Requests;
import by.yarik.test_belarusbank.api.belarusbank.Api;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.IBasePresenter;

public abstract class BaseFragment<P extends IBasePresenter> extends MvpAppCompatFragment implements IBaseView {

    private ProgressDialog progressDialog;

    protected Requests requests;
    protected Unbinder unbinder;
    protected ResourceManager resourceManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        resourceManager = new ResourceManager(getContext());
        requests = new Requests(Api.getBelarusbankApi());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(resourcesLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initProgressDialog();
        return onCreateView(view, savedInstanceState);
    }

    private void initProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.loading_wait));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onViewCreated();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    protected Requests getRequests() {
        return requests;
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    protected abstract int resourcesLayout();

    protected abstract View onCreateView(View view, @Nullable Bundle savedInstanceState);

    protected abstract P getPresenter();

    public abstract P initPresenter();
}
