package com.example.ccplaces.UI;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.R;
import com.example.ccplaces.ViewModel.CategoriaViewModel;
import com.example.ccplaces.ViewModel.MonumentoViewModel;
import com.example.ccplaces.ViewModel.SharedViewModel;
import com.example.ccplaces.ViewModel.ViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment {


    private RecyclerView recyclerView;
    private ListaMonumentosAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public CategoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_categoria, container, false);
        SharedViewModel model =  new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        String cat=model.getCategoria().getValue();

        if(cat!=null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(cat);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_cat);

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

        CategoriaViewModel catViewModel = new ViewModelProvider(this,new ViewModelFactory(getActivity().getApplication(),cat)).get(CategoriaViewModel.class);


        catViewModel.getmMonumentosCat().observe(getViewLifecycleOwner(), new Observer<List<Monumento>>() {
            @Override
            public void onChanged(@Nullable final List<Monumento> monumentos) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setMonumentos(monumentos);
            }
        });


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        model.select(catViewModel.getmMonumentosCat().getValue().get(position));
                        Navigation.findNavController(view).navigate(R.id.action_categoria_to_nav_detalle_monumento);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        // Inflate the layout for this fragment
        return  v;
    }

}
