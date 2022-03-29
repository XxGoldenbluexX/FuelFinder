package fr.antony_garcia.fuelfinder.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.antony_garcia.fuelfinder.R;
import fr.antony_garcia.fuelfinder.model.Station;

public class StationDetailFragment extends Fragment {

    private TextView tv_place;//adresse
    private TextView tv_city;
    private TextView tv_brand;
    private TextView tv_gazole;
    private TextView tv_e85;
    private TextView tv_sp98;
    private TextView tv_last_update;
    private Button btn_viewOnMap;
    private View root;

    private Station station;

    public StationDetailFragment(){
        super(R.layout.stationdetail_fragment);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Get elements from the layout
        tv_place = view.findViewById(R.id.tv_sd_place);
        tv_city = view.findViewById(R.id.tv_sd_city);
        tv_brand = view.findViewById(R.id.tv_sd_brand);
        tv_gazole = view.findViewById(R.id.tv_sd_gazole);
        tv_e85 = view.findViewById(R.id.tv_sd_e85);
        tv_sp98 = view.findViewById(R.id.tv_sd_sp98);
        tv_last_update = view.findViewById(R.id.tv_sd_last_update);
        btn_viewOnMap = view.findViewById(R.id.btn_viewOnMap);
        root = view;
        //Retrieve station
        Serializable o = getArguments().getSerializable("station");
        if (o instanceof Station){
            station = (Station) o;
        }
        //show values on fields
        if (station!=null){
            tv_place.setText(station.getPlace());
            tv_city.setText(station.getCity());
            tv_brand.setText(station.getBrand());
            tv_gazole.setText(station.getPriceGazole());
            tv_e85.setText(station.getPriceE85());
            tv_sp98.setText(station.getPrice_sp98());

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
                Date date = null;
                date = formatter.parse(station.getLastUpdate());
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                tv_last_update.setText(formatter.format(date));
            } catch (ParseException e) {
                tv_last_update.setText("Unknown");
            }
        }
        //Button view on map
        if (station!=null){
            btn_viewOnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (root!=null) {
                        NavController navController = Navigation.findNavController(root);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("station",station);
                        navController.navigate(R.id.stationMapFragment,bundle);
                    }
                }
            });
        }
    }
}
