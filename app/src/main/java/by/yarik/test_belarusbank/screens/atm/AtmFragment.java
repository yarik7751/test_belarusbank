package by.yarik.test_belarusbank.screens.atm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;

public class AtmFragment extends BaseFragment<IAtmPresenter> implements IAtmView, OnMapReadyCallback {

    public static AtmFragment newInstance() {
        return new AtmFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_atm;
    }

    @Override
    protected void setPresenter() {
        presenter = new AtmPresenter(this, resourceManager);
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
