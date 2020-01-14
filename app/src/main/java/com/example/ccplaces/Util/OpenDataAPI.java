package com.example.ccplaces.Util;

import android.content.Context;
import android.util.Log;

import com.example.ccplaces.MainActivity;
import com.example.ccplaces.Model.Monumento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class OpenDataAPI {


    private final static String TAG="OpenDataAPI";

    public static void getMonumentosFromJSON(JSONObject result, ArrayList<Monumento> monumentoArrayList){

        JSONObject jsonObject;
        JSONArray jsonArray;
        String nombreMonumento,desc,tipo,lat,lon;
        int imgId;
       RandomInfo ri=new RandomInfo();

        try {
            jsonObject = result.getJSONObject("results");
            jsonArray = jsonObject.getJSONArray("bindings");

            for(int i=0; i< jsonArray.length();i++){
                nombreMonumento  = jsonArray.getJSONObject(i).getJSONObject("rdfs_label").getString("value");
                tipo= jsonArray.getJSONObject(i).getJSONObject("om_tipoMonumento").getString("value");
                desc=ri.getDescripcion();
                imgId=ri.getFoto();
//                lat= jsonArray.getJSONObject(i).getJSONObject("geo_lat").getString("value");
//                lon= jsonArray.getJSONObject(i).getJSONObject("geo_long").getString("value");
                        monumentoArrayList.add(new Monumento(nombreMonumento,tipo,desc,imgId));
                Log.i(TAG," Creado: "+nombreMonumento+" ["+tipo+"]");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
