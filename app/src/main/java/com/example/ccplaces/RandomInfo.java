package com.example.ccplaces;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

import java.util.Random;

public class RandomInfo {



    private Context context;

    public RandomInfo(Context current){
        this.context = current;
    }


    public String getDescripcion(){
        //TODO: 2. Ampliar el array de descripciones
        Resources res = context.getResources();
        String[] descs = res.getStringArray(R.array.array_descripciones);
        Random r = new Random();
        int randomIndex = r.nextInt(descs.length);
        return descs[randomIndex];
    }

    public Bitmap getFoto(){
        return null;
    }




}
