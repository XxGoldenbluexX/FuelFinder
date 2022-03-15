package fr.antony_garcia.fuelfinder.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Station implements Serializable {

    private String place;

    private String city;

    private String brand;

    private String price;

    public Station(JSONObject obj){
        try {
            JSONObject fields = obj.getJSONObject("fields");
            place = fields.has("address")?fields.getString("address"):"";
            city = fields.has("city")?fields.getString("city"):"";
            brand = fields.has("brand")?fields.getString("brand"):"";
            String fld = Carburant.GAZOIL.getField();
            price = fields.has(fld)?fields.getString(fld):"";
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

    public String getPrice() {
        return price;
    }
}
