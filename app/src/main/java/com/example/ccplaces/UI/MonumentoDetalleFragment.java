package com.example.ccplaces.UI;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.R;
import com.example.ccplaces.ViewModel.MonumentoDetalleViewModel;
import com.example.ccplaces.ViewModel.MonumentoViewModel;
import com.example.ccplaces.ViewModel.SharedViewModel;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentoDetalleFragment extends Fragment {


    private String nombre="",descripcion="";
    private TextView tv_nombre, tv_desc;
    private ImageView img;
    private Monumento m;

    public MonumentoDetalleFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_monumento, container, false);

        tv_desc=v.findViewById(R.id.tv_descripcion);
        tv_nombre=v.findViewById(R.id.tv_detalles_nombre);
        img=v.findViewById(R.id.fotoMonumento);

        SharedViewModel model =  new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        m=model.getSelected().getValue();


        MonumentoDetalleViewModel monumentoDetalleViewModel = new ViewModelProvider(this).get(MonumentoDetalleViewModel.class);
        monumentoDetalleViewModel.setMonumento(model.getSelected());


        if(m!=null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(m.getNombre());

        tv_nombre.setText(m.getNombre());
        tv_desc.setText(m.getDesc());
        img.setImageResource(m.getImgId());

        ToggleButton toggle = (ToggleButton) v.findViewById(R.id.button_favorite);
        toggle.setChecked(m.getFavorito());
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                m.setFavorito(isChecked);
                monumentoDetalleViewModel.updateMonumento(m);
            }
        });



        return v;
    }

}
