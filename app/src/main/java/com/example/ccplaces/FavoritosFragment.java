package com.example.ccplaces;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public FavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_puntos_interes, container, false);
        //new PuntosInteresFragment.GetMonumentos().execute();

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_pdi);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new GridLayoutManager(this.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new PuntoInteresAdapter(Datos.getInstance().getFavoritos());
        recyclerView.setAdapter(mAdapter);
    return v;
    }

}
