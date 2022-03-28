package fr.antony_garcia.fuelfinder.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Station implements Serializable {

    private String place = "";

    private String city = "";

    private String brand = "";

    private String price_gazole = "";

    private String price_e85 = "";

    private String price_sp98 = "";

    private String last_update = "";

    public Station(JSONObject obj){
        try {
            JSONObject fields = obj.getJSONObject("fields");
            place = fields.has("address")?fields.getString("address"):"";
            city = fields.has("city")?fields.getString("city"):"";
            brand = fields.has("brand")?fields.getString("brand"):"";
            price_gazole = fields.has("price_gazole")?fields.getString("price_gazole"):"";
            price_e85 = fields.has("price_e85")?fields.getString("price_e85"):"";
            price_sp98 = fields.has("price_sp98")?fields.getString("price_sp98"):"";
            last_update = fields.has("update")?fields.getString("update"):"";
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getPlace() {
        return place;
    }

    public String getCity() {
        return city;
    }

    public String getBrand() {
        return brand;
    }

    public String getPriceGazole() {
        return price_gazole;
    }

    public String getPriceE85() {
        return price_e85;
    }

    public String getPrice_sp98() {
        return price_sp98;
    }

    public String getLastUpdate(){
        return last_update;
    }
}
