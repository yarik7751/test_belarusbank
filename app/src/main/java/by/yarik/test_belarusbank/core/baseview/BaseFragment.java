package by.yarik.test_belarusbank.core.baseview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.api.Api;
import by.yarik.test_belarusbank.api.IApi;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.basepresenter.IBasePresenter;

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView {

    private ProgressDialog progressDialog;

    protected T presenter;
    protected Unbinder unbinder;
    protected ResourceManager resourceManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        resourceManager = new ResourceManager(getContext());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(resourcesLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initProgressDialog();

        if(presenter == null) {
            setPresenter();
        }
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

    protected IApi getBelarusbankApi() {
        return Api.getBelarusbankApi(getContext());
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

    protected T getPresenter() {
        return presenter;
    }

    protected abstract void setPresenter();
}
