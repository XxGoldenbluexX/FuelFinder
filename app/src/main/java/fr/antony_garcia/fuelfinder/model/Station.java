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
            place = fields.has("adress")?fields.getString("address"):"";
            city = fields.has("city")?fields.getString("city"):"";
            brand = fields.has("brand")?fields.getString("brand"):"";
            price = fields.has("price")?fields.getString("price"):"";
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
