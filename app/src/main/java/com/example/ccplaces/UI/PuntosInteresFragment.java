package com.example.ccplaces.UI;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.Util.Network;
import com.example.ccplaces.Util.OpenDataAPI;
import com.example.ccplaces.ViewModel.MonumentoViewModel;
import com.example.ccplaces.R;
import com.example.ccplaces.ViewModel.SharedViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PuntosInteresFragment extends Fragment {


    private final static String TAG="PDI";



    private MonumentoViewModel monumentoViewModel;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ListaMonumentosAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedViewModel model;


    public PuntosInteresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_puntos_interes, container, false);

        fab= v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetMonumentos().execute();
            }
        });


        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_pdi);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        //Para usar un Grid Layout de 3 columnas descomentar la instruccion de abajo y comentar la de arriba
//        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),3));


        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new ListaMonumentosAdapter(this.getContext());

        recyclerView.setAdapter(mAdapter);

        monumentoViewModel = new ViewModelProvider(this).get(MonumentoViewModel.class);


        monumentoViewModel.getmAllMonumentos().observe(getViewLifecycleOwner(), new Observer<List<Monumento>>() {
            @Override
            public void onChanged(@Nullable final List<Monumento> monumentos) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setMonumentos(monumentos);
            }
        });

        model = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        model.select(monumentoViewModel.getmAllMonumentos().getValue().get(position));
                        Navigation.findNavController(view).navigate(R.id.action_nav_puntos_interes_to_nav_detalle_monumento);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        return v;
    }






    private class GetMonumentos extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        ArrayList<Monumento> listaMonumentos=new ArrayList<Monumento>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listaMonumentos.clear();
            progressDialog = ProgressDialog.show(getContext(),
                    "Descargando espere...",
                    "Datos proporcionados por OpenDataAPI");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                JSONObject jsonObject = Network.getJSONObjectFromURL(Network.URL_OPENDATA);
                OpenDataAPI.getMonumentosFromJSON(jsonObject,listaMonumentos,getContext());

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            progressDialog.dismiss();
            super.onPostExecute(aVoid);
            for(Monumento m: listaMonumentos)
                monumentoViewModel.insert(m);

        }
    }













}
