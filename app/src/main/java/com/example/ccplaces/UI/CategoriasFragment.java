package com.example.ccplaces.UI;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ccplaces.R;
import com.example.ccplaces.ViewModel.SharedViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriasFragment extends Fragment {

    private TextView tv_Iglesia,tv_Concatedral,tv_Ermita,tv_Convento,tv_torre,tv_casa,
            tv_monumento,tv_palacio,tv_escultura,tv_edificio,tv_singular,tv_crucero,tv_excavacion;
    private SharedViewModel Sharedmodel;

    public CategoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_categorias, container, false);
        Sharedmodel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        tv_Iglesia=v.findViewById(R.id.tv_iglesia);
        tv_Concatedral=v.findViewById(R.id.tv_Concatedral);
        tv_Ermita=v.findViewById(R.id.tv_ermita);
        tv_Convento=v.findViewById(R.id.tv_convento);
        tv_torre=v.findViewById(R.id.tv_torre);
        tv_casa=v.findViewById(R.id.tv_casa);
        tv_monumento=v.findViewById(R.id.tv_monumento);
        tv_palacio=v.findViewById(R.id.tv_palacio);
        tv_escultura=v.findViewById(R.id.tv_escultura);
        tv_edificio=v.findViewById(R.id.tv_eSingular);
        tv_crucero=v.findViewById(R.id.tv_crucero);





        tv_Iglesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Iglesia");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_Concatedral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Concatedral");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_Ermita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Ermita");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });
        tv_Convento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Convento");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_torre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Torre");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Casa");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_monumento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Monumento");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_palacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Palacio");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_escultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Escultura");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });
        tv_crucero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Crucero");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        tv_edificio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sharedmodel.selectCategoria("Edificio Singular");
                Navigation.findNavController(v).navigate(R.id.action_nav_categorias_to_categoria);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }


















}
