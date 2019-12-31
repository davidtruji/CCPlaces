package com.example.ccplaces.UI;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.R;
import com.example.ccplaces.ViewModel.FavoritosViewModel;
import com.example.ccplaces.ViewModel.MonumentoViewModel;
import com.example.ccplaces.ViewModel.SharedViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    private RecyclerView recyclerView;
    private PuntoInteresAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedViewModel model;
    private FavoritosViewModel favoritosViewModel;

    public FavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_favoritos, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_fav);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this.getContext());
        //Para usar un Grid Layout de 3 columnas descomentar la instruccion de abajo y comentar la de arriba
//        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),3));


        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new PuntoInteresAdapter(this.getContext());

        recyclerView.setAdapter(mAdapter);

        favoritosViewModel = new ViewModelProvider(this).get(FavoritosViewModel.class);


        favoritosViewModel.getmMonumentosFavoritos().observe(getViewLifecycleOwner(), new Observer<List<Monumento>>() {
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
//                        Toast.makeText(getContext(),"tocao "+position,Toast.LENGTH_SHORT).show();
                        model.select(favoritosViewModel.getmMonumentosFavoritos().getValue().get(position));
                        Navigation.findNavController(view).navigate(R.id.action_nav_favoritos_to_nav_detalle_monumento);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );






        return v;
    }







}
