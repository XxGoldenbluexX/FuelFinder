package fr.antony_garcia.fuelfinder.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.model.Station;

public class StationMapFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;

    Station station;

    public StationMapFragment(){
        super(R.layout.stationmap_fragment);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //HH
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        MapsInitializer.initialize(mapView.getContext());
        mapView.getMapAsync(this);
        //Get station
        Serializable o = getArguments().getSerializable("station");
        if (o instanceof Station){
            station = (Station)o;
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        if (station!=null) {
            LatLng coord = new LatLng(station.getLatitude(), station.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(coord));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord,12f));
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        if (mapView!=null){
            mapView.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView!=null){
            mapView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mapView!=null){
            mapView.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mapView!=null){
            mapView.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapView!=null){
            mapView.onDestroy();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (mapView!=null){
            mapView.onLowMemory();
        }
    }
}
