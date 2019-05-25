package by.yarik.atm.presentation.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import by.yarik.atm.R;
import by.yarik.atm.presentation.presenter.AtmPresenter;
import by.yarik.atm.presentation.presenter.IAtmPresenter;
import by.yarik.atm.viewmodel.AtmViewModel;
import by.yarik.core.core.baseview.BaseFragment;

public class AtmFragment extends BaseFragment<IAtmPresenter> implements IAtmView, OnMapReadyCallback {

    protected MapView mapMapView;
    protected FloatingActionButton searchAtmButton;

    @InjectPresenter
    public AtmPresenter presenter;

    private GoogleMap googleMap;
    private AlertDialog searchAtmDialog;

    public static AtmFragment newInstance() {
        return new AtmFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_atm;
    }

    @Override
    @ProvidePresenter
    public AtmPresenter initPresenter() {
        return new AtmPresenter(resourceManager);
    }

    @Override
    protected IAtmPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        initFields(view);
        mapMapView.onCreate(savedInstanceState);
        getPresenter().onCreateView();
        return view;
    }

    private void initFields(View view) {
        mapMapView = view.findViewById(R.id.map);
        searchAtmButton = view.findViewById(R.id.fab_search_atm);
        searchAtmButton.setOnClickListener(view1 -> showDialog());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        getPresenter().onMapReady();
    }

    @Override
    public void initUi() {
        mapMapView.onResume();

        MapsInitializer.initialize(getActivity().getApplicationContext());
        mapMapView.getMapAsync(this);
    }

    private void showDialog() {
        Activity activity = getActivity();
        if (activity != null) {

            if (searchAtmDialog == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);

                LayoutInflater layoutInflater = LayoutInflater.from(activity.getApplicationContext());
                View view = layoutInflater.inflate(R.layout.dialog_choose_atm, null);

                builder.setTitle(R.string.atm_search_title);
                builder.setView(view);
                builder.setPositiveButton(R.string.atm_find, (dialogInterface, i) -> {
                    getPresenter().onFindAtmClick();
                });
                builder.setNegativeButton(R.string.atm_cancel, (dialogInterface, i) -> {
                });

                EditText city = view.findViewById(R.id.et_city);
                city.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence working, int i, int i1, int i2) {
                        getPresenter().onCityChange(working.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                });

                CheckBox usdCurrency = view.findViewById(R.id.cb_atm_usd);
                usdCurrency.setOnCheckedChangeListener((compoundButton, checked) -> getPresenter().onUsdChange(checked));

                CheckBox eurCurrency = view.findViewById(R.id.cb_atm_eur);
                eurCurrency.setOnCheckedChangeListener((compoundButton, checked) -> getPresenter().onEurChange(checked));

                CheckBox bynCurrency = view.findViewById(R.id.cb_atm_byn);
                bynCurrency.setChecked(true);
                getPresenter().onBynChange(true);

                searchAtmDialog = builder.create();
            }
            searchAtmDialog.show();
        }
    }

    @Override
    public void showInfoMessage(String info) {

    }

    @Override
    public void updateAtms(List<AtmViewModel> viewModels) {
        googleMap.clear();
        List<Marker> markers = new ArrayList<>();
        for (AtmViewModel viewModel : viewModels) {
            Marker marker = addMarker(viewModel);
            markers.add(marker);
        }

        LatLngBounds bounds = getCoordinatesBounds(markers);
        CameraUpdate cameraUpdate = getCameraUpdate(bounds);
        googleMap.moveCamera(cameraUpdate);
    }

    private Marker addMarker(AtmViewModel viewModel) {
        LatLng position = new LatLng(Double.parseDouble(viewModel.getLat()), Double.parseDouble(viewModel.getLng()));

        return googleMap.addMarker(new MarkerOptions()
                .position(position)
                .title(viewModel.getText()));
    }

    private LatLngBounds getCoordinatesBounds(List<Marker> markers) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : markers) {
            builder.include(marker.getPosition());
        }

        return builder.build();
    }

    private CameraUpdate getCameraUpdate(LatLngBounds latLngBounds) {
        int position = 0;
        return CameraUpdateFactory.newLatLngBounds(latLngBounds, position);
    }
}
