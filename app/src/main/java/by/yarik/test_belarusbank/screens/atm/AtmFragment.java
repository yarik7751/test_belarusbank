package by.yarik.test_belarusbank.screens.atm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.google.android.gms.common.util.NumberUtils;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import by.yarik.test_belarusbank.R;
import by.yarik.test_belarusbank.core.baseview.BaseFragment;
import by.yarik.test_belarusbank.data.atm.AtmRepository;
import by.yarik.test_belarusbank.domain.atm.AtmInteractor;
import by.yarik.test_belarusbank.domain.atm.IAtmInteractor;
import by.yarik.test_belarusbank.domain.atm.IAtmRepository;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;

public class AtmFragment extends BaseFragment<IAtmPresenter> implements IAtmView, OnMapReadyCallback {

    @BindView(R.id.map)
    protected MapView mapMapView;

    private GoogleMap googleMap;

    public static AtmFragment newInstance() {
        return new AtmFragment();
    }

    @Override
    protected int resourcesLayout() {
        return R.layout.fragment_atm;
    }

    @Override
    protected void setPresenter() {
        IAtmRepository repository = new AtmRepository(requests);
        IAtmInteractor interactor = new AtmInteractor(repository, resourceManager);
        presenter = new AtmPresenter(this, resourceManager, interactor);
    }

    @Override
    protected View onCreateView(View view, @Nullable Bundle savedInstanceState) {
        mapMapView.onCreate(savedInstanceState);
        getPresenter().onCreateView();
        return view;
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

    @Override
    public void updateAtms(List<AtmViewModel> viewModels) {
        List<Marker> markers = new ArrayList<>();
        for(AtmViewModel viewModel : viewModels) {
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
        for(Marker marker : markers) {
            builder.include(marker.getPosition());
        }

        return builder.build();
    }

    private CameraUpdate getCameraUpdate(LatLngBounds latLngBounds) {
        int position = 0;
        return CameraUpdateFactory.newLatLngBounds(latLngBounds, position);
    }
}
