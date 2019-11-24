package com.example.ccplaces;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PuntosInteresFragment extends Fragment {

    private ArrayList<Monumento> listaMonumentos=Datos.getInstance().getPuntosIneres();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;




    public PuntosInteresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_puntos_interes, container, false);
       new GetMonumentos().execute();

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_pdi);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new GridLayoutManager(this.getContext(),3);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new PuntoInteresAdapter(listaMonumentos);
        recyclerView.setAdapter(mAdapter);
//        // specify an adapter (see also next example)
//        mAdapter = new PuntoInteresAdapter(listaMonumentos);
//        recyclerView.setAdapter(mAdapter);


//        tv_consulta = (TextView) v.findViewById(R.id.tv_consulta);
//        bt_try = (Button) v.findViewById(R.id.bt_try);
//        bt_try.setOnClickListener(btListener);


        return v;
    }












    private class GetMonumentos extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        ArrayList<Monumento> puntosIneres=Datos.getInstance().getPuntosIneres();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listaMonumentos.clear();
            progressDialog = ProgressDialog.show(getActivity(),
                    "Descargando espere...",
                    "Datos proporcionados por OpenDataAPI");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                JSONObject jsonObject = Network.getJSONObjectFromURL(Network.URL_OPENDATA);
                OpenDataAPI.getMonumentosFromJSON(jsonObject,listaMonumentos);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mAdapter = new PuntoInteresAdapter(listaMonumentos);
            recyclerView.setAdapter(mAdapter);
            progressDialog.dismiss();
            super.onPostExecute(aVoid);
        }
    }







}
