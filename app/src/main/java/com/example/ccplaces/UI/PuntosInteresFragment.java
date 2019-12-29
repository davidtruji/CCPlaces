package com.example.ccplaces.UI;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PuntosInteresFragment extends Fragment {


    private final static String TAG="PDI";




    private ArrayList<Monumento> listaMonumentos= new ArrayList<>();
    //    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;
    private MonumentoViewModel monumentoViewModel;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private PuntoInteresAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public PuntosInteresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_puntos_interes, container, false);
        // new GetMonumentos().execute();
        //monumentoViewModel = ViewModelProviders.of(this, viewModelFactory).get( monumentoViewModel.class);

        fab= v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetMonumentos().execute();
            }
        });

//        RecyclerView recyclerView = v.findViewById(R.id.recycler_pdi);
//        final PuntoInteresAdapter adapter = new PuntoInteresAdapter(this.getContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),3));



        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_pdi);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new PuntoInteresAdapter(this.getContext());
        recyclerView.setAdapter(mAdapter);


        monumentoViewModel = new ViewModelProvider(this).get(MonumentoViewModel.class);


        monumentoViewModel.getmAllMonumentos().observe(getViewLifecycleOwner(), new Observer<List<Monumento>>() {
            @Override
            public void onChanged(@Nullable final List<Monumento> monumentos) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setWords(monumentos);
            }
        });

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
                OpenDataAPI.getMonumentosFromJSON(jsonObject,listaMonumentos);

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
//MonumentosRoomDataBase db = MonumentosRoomDataBase.getDatabase(MainActivity.this);
            //mAdapter = new PuntoInteresAdapter(listaMonumentos);
            // recyclerView.setAdapter(mAdapter);
            progressDialog.dismiss();
            super.onPostExecute(aVoid);
            for(Monumento m: listaMonumentos)
                monumentoViewModel.insert(m);

            for(Monumento m: monumentoViewModel.getmAllMonumentos().getValue())
            Log.i(TAG,m.toString());

        }
    }













}
