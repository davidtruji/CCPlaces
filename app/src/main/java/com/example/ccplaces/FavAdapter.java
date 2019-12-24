package com.example.ccplaces;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.Navigation;

import java.util.ArrayList;

public abstract class FavAdapter extends PuntoInteresAdapter {

    public FavAdapter(ArrayList<Monumento> myDataset) {
        super(myDataset);
    }

    public  void onItemClick(View v, int i){
        Toast.makeText(v.getContext(),"Click: "+super.getmDataset().get(i).toString(), Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        //Navigation.findNavController(view).navigate(R.id.confirmationAction, bundle);
        Navigation.findNavController(v).navigate(R.id.action_nav_favoritos_to_nav_detalle_monumento,bundle);
    }






}
