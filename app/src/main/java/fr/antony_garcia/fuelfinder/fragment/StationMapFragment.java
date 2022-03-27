package fr.antony_garcia.fuelfinder.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.antony_garcia.fuelfinder.EndlessRecyclerViewScrollListener;
import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.StationAdapter;
import fr.antony_garcia.fuelfinder.model.Station;
import fr.antony_garcia.fuelfinder.task.SeekStationsTask;

public class StationMapFragment extends Fragment {

    public StationMapFragment(){
        super(R.layout.stationmap_fragment);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
