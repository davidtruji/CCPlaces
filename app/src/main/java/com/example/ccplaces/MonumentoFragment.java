package com.example.ccplaces;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentoFragment extends Fragment {


    private String nombre="",descripcion="";
    private TextView tv_nombre, tv_desc;

    public MonumentoFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_monumento, container, false);
        tv_desc=v.findViewById(R.id.tv_descripcion);
        tv_nombre=v.findViewById(R.id.tv_nombre_monumento);
        nombre=getArguments().getString("nombre");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(nombre);
        tv_nombre.setText(nombre);
        tv_desc.setText((new RandomInfo(getContext())).getDescripcion());
        // Inflate the layout for this fragment
        return v;
    }

}
