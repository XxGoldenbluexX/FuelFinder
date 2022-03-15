package fr.antony_garcia.fuelfinder.task;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import fr.antony_garcia.fuelfinder.StationAdapter;
import fr.antony_garcia.fuelfinder.model.Station;

public class SeekStationsTask extends AsyncTask<String,Void, List<Station>> {

    private final List<Station> liste;
    private final StationAdapter adapter;

    public SeekStationsTask(List<Station> liste, StationAdapter stationAdapter){
        this.liste = liste;
        adapter = stationAdapter;
    }

    @Override
    protected List<Station> doInBackground(String... queries) {
        List<Station> list = new ArrayList<>();
        if (queries.length>0){
            try{
                URL url = new URL(queries[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if (conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder builder = new StringBuilder();
                    String read = "";
                    while (read!=null){
                        builder.append(read);
                        read = reader.readLine();
                    }
                    JSONObject result = new JSONObject(builder.toString());
                    reader.close();
                    JSONArray stations = result.getJSONArray("records");
                    for (int i = 0; i<stations.length();i++){
                        list.add(new Station(stations.getJSONObject(i)));
                    }
                }
                conn.disconnect();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<Station> stations) {
        super.onPostExecute(stations);
        liste.addAll(stations);
        adapter.notifyDataSetChanged();
    }
}
