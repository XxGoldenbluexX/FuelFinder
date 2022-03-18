package fr.antony_garcia.fuelfinder.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.antony_garcia.fuelfinder.EndlessRecyclerViewScrollListener;
import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.StationAdapter;
import fr.antony_garcia.fuelfinder.model.Station;
import fr.antony_garcia.fuelfinder.task.SeekStationsTask;

public class StationListActivity extends AppCompatActivity {

    private Button btn_submit;
    private EditText et_query;
    private RecyclerView rv_stationList;
    private StationAdapter stationAdapter;
    private final List<Station> liste = new ArrayList<>();
    private String lastQuery = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stationlist_activity);
        //ActionBar
        setSupportActionBar(findViewById(R.id.sla_toolbar));
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(NavControllernavController.getGraph())
                        .setOpenableLayout(R.id.sla_nv_drawer)
                        .build();
        //Get elements from the layout
        btn_submit = findViewById(R.id.btn_search);
        et_query = findViewById(R.id.et_query);
        rv_stationList = findViewById(R.id.rv_stationList);
        //Create adapter
        stationAdapter = new StationAdapter(this,liste);
        //param RecyclerView
        rv_stationList.setAdapter(stationAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_stationList.setLayoutManager(llm);
        rv_stationList.addOnScrollListener(new EndlessRecyclerViewScrollListener(llm) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                new SeekStationsTask(liste,stationAdapter).execute(
                        "https://public.opendatasoft.com/api/records/1.0/search/?dataset=prix_des_carburants_j_7&sort=-price_gazole&rows=10&start="+10*page+"&q="+lastQuery
                );
            }
        });
        //Handle events
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liste.clear();
                stationAdapter.notifyDataSetChanged();
                lastQuery = et_query.getText().toString();
                new SeekStationsTask(liste,stationAdapter).execute(
                        "https://public.opendatasoft.com/api/records/1.0/search/?dataset=prix_des_carburants_j_7&q=&sort=-price_gazole&rows=10&q="+lastQuery
                );//TODO change query with the EditText's value
            }
        });
    }
}