package fr.antony_garcia.fuelfinder.task;

import android.os.AsyncTask;

import java.util.List;

import fr.antony_garcia.fuelfinder.model.Station;

public class SeekStationsTask extends AsyncTask<String,Void, List<Station>> {


    @Override
    protected List<Station> doInBackground(String... query) {
        return null;
    }

    @Override
    protected void onPostExecute(List<Station> stations) {
        super.onPostExecute(stations);
    }
}
