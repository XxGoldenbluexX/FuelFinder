package fr.antony_garcia.fuelfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.antony_garcia.fuelfinder.model.Station;

public class StationAdapter extends RecyclerView.Adapter {

    private final Context context;

    private final List<Station> liste;

    private final LayoutInflater inflater;

    public StationAdapter(Context context, List<Station> liste){
        this.context = context;
        this.liste = liste;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StationItemHolder(inflater.inflate(R.layout.station_listitem, parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StationItemHolder){
            ((StationItemHolder) holder).load(liste.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    private class StationItemHolder extends RecyclerView.ViewHolder{

        private final TextView sli_place;
        private final TextView sli_city;
        private final TextView sli_brand;
        private final TextView sli_price;

        public StationItemHolder(View itemView) {
            super(itemView);
            sli_place = itemView.findViewById(R.id.sli_place);
            sli_brand = itemView.findViewById(R.id.sli_brand);
            sli_price = itemView.findViewById(R.id.sli_price);
            sli_city = itemView.findViewById(R.id.sli_city);
        }

        public void load(Station s){
            sli_place.setText(s.getPlace());
            sli_brand.setText(s.getBrand());
            sli_price.setText(s.getPrice());
            sli_city.setText(s.getCity());
        }
    }
}
