package com.example.ccplaces;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentoFragment extends Fragment {


    //private String nombre="",descripcion="";
    private TextView tv_nombre, tv_desc;
    private Monumento m;

    public MonumentoFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_monumento, container, false);
        tv_desc=v.findViewById(R.id.tv_descripcion);
        tv_nombre=v.findViewById(R.id.tv_nombre_monumento);
        m=Datos.getInstance().getPuntosIneres().get(getArguments().getInt("index"));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(m.getNombre());
        ToggleButton toggle = (ToggleButton) v.findViewById(R.id.button_favorite);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    if(!Datos.getInstance().getFavoritos().contains(m)){
                        Datos.getInstance().getFavoritos().add(m);
                    }


                } else {
                    // The toggle is disabled
                    Datos.getInstance().getFavoritos().remove(m);
                }
            }
        });

        tv_nombre.setText(m.getNombre());
        tv_desc.setText((new RandomInfo(getContext())).getDescripcion());
        // Inflate the layout for this fragment
        return v;
    }

}
