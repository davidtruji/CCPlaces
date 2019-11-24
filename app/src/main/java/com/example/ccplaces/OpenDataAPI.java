package com.example.ccplaces;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OpenDataAPI {


    private final static String TAG="OpenDataAPI";

    public static void getMonumentosFromJSON(JSONObject result, ArrayList<Monumento> monumentoArrayList){

        JSONObject jsonObject;
        JSONArray jsonArray;
        String nombreMonumento,desc,tipo;
        Long lat=0L,lon=0L;

        try {
            jsonObject = result.getJSONObject("results");
            jsonArray = jsonObject.getJSONArray("bindings");

            for(int i=0; i< jsonArray.length();i++){
                nombreMonumento  = jsonArray.getJSONObject(i).getJSONObject("rdfs_label").getString("value");
                tipo= jsonArray.getJSONObject(i).getJSONObject("om_tipoMonumento").getString("value");
                //lat= Long.valueOf(jsonArray.getJSONObject(i).getJSONObject("geo_lat").getString("value"));
                //lon= Long.valueOf(jsonArray.getJSONObject(i).getJSONObject("geo_long").getString("value"));
                monumentoArrayList.add(new Monumento(nombreMonumento,tipo,"desc",null,lat,lon));
                Log.i(TAG," Creado: "+nombreMonumento+" - "+tipo+" - "+lat.toString()+" "+lon.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
