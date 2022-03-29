package fr.antony_garcia.fuelfinder.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import fr.antony_garcia.fuelfinder.EndlessRecyclerViewScrollListener;
import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.RecyclerViewItemClickListener;
import fr.antony_garcia.fuelfinder.StationAdapter;
import fr.antony_garcia.fuelfinder.model.Station;
import fr.antony_garcia.fuelfinder.task.SeekStationsTask;

public class StationListFragment extends Fragment implements RecyclerViewItemClickListener<Station> {

    private Button btn_submit;
    private EditText et_query;
    private RecyclerView rv_stationList;
    private StationAdapter stationAdapter;
    private final List<Station> liste = new ArrayList<>();
    private String lastQuery = "";

    public StationListFragment(){
        super(R.layout.stationlist_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Get elements from the layout
        btn_submit = view.findViewById(R.id.btn_search);
        et_query = view.findViewById(R.id.et_query);
        rv_stationList = view.findViewById(R.id.rv_stationList);
        //Create adapter
        stationAdapter = new StationAdapter(getActivity(),liste,this);
        //param RecyclerView
        rv_stationList.setAdapter(stationAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
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
                ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                    liste.clear();
                    stationAdapter.notifyDataSetChanged();
                    lastQuery = et_query.getText().toString();
                    new SeekStationsTask(liste, stationAdapter).execute(
                            "https://public.opendatasoft.com/api/records/1.0/search/?dataset=prix_des_carburants_j_7&q=&sort=-price_gazole&rows=10&q=" + lastQuery
                    );
                }else{
                    Snackbar.make(view,R.string.noInternet,Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemClick(Station station) {
        NavController navController = Navigation.findNavController(rv_stationList);
        Bundle bundle = new Bundle();
        bundle.putSerializable("station",station);
        navController.navigate(R.id.stationDetailFragment,bundle);
    }
}
