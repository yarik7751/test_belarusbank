package by.yarik.core.core.baseview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import by.yarik.core.R;
import by.yarik.core.api.Requests;
import by.yarik.core.api.belarusbank.Api;
import by.yarik.core.core.ResourceManager;
import by.yarik.core.core.basepresenter.IBasePresenter;

public abstract class BaseFragment<P extends IBasePresenter> extends MvpAppCompatFragment implements IBaseView {

    private ProgressDialog progressDialog;

    protected Requests requests;
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
