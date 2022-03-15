package fr.antony_garcia.fuelfinder.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.StationAdapter;
import fr.antony_garcia.fuelfinder.model.Station;

public class StationListActivity extends AppCompatActivity {

    private Button btn_submit;
    private EditText et_query;
    private RecyclerView rv_stationList;
    private StationAdapter stationAdapter;
    private final List<Station> liste = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stationlist_activity);
        //Get elements from the layout
        btn_submit = findViewById(R.id.btn_search);
        et_query = findViewById(R.id.et_query);
        rv_stationList = findViewById(R.id.rv_stationList);
        //Create adapter
        stationAdapter = new StationAdapter(this,liste);
        rv_stationList.setAdapter(stationAdapter);

    }
}