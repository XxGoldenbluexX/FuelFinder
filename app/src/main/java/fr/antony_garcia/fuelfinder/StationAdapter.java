package fr.antony_garcia.fuelfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return new StationItemHolder(inflater.inflate(R.layout.station_listitem, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StationItemHolder){
            StationItemHolder h = (StationItemHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    private class StationItemHolder extends RecyclerView.ViewHolder{



        public StationItemHolder(View itemView) {
            super(itemView);

        }

    }
}
