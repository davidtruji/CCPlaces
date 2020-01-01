package com.example.ccplaces.Util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.ccplaces.R;

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

    public int getFoto() {
        Resources res = context.getResources();
        int[] images = {R.drawable.m1,R.drawable.m2,R.drawable.m3,
                R.drawable.m4,R.drawable.m5,R.drawable.m6,R.drawable.m7,R.drawable.m8,R.drawable.m9,
                R.drawable.m10,R.drawable.m11,R.drawable.m12,R.drawable.m13,R.drawable.m14,R.drawable.m15,
                R.drawable.m16,R.drawable.m17,R.drawable.m18,R.drawable.m19,R.drawable.m20,R.drawable.m21,R.drawable.m22,R.drawable.m23};
        Random r = new Random();
        int randomIndex = r.nextInt(images.length);
        return images[randomIndex];
    }




}
