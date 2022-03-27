package fr.antony_garcia.fuelfinder.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;

import java.util.ArrayList;
import java.util.List;

import fr.antony_garcia.fuelfinder.EndlessRecyclerViewScrollListener;
import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.StationAdapter;
import fr.antony_garcia.fuelfinder.model.Station;
import fr.antony_garcia.fuelfinder.task.SeekStationsTask;

public class StationMapFragment extends Fragment {

    MapView mapView;

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
