package com.example.ccplaces;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PuntoInteresAdapter extends  RecyclerView.Adapter<PuntoInteresAdapter.PuntoInteresViewHolder> {

    private ArrayList<Monumento> mDataset;


    public class PuntoInteresViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView textView;
        public PuntoInteresViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.tv_nombre_monummento);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClick(view, getAdapterPosition());
        }


    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public PuntoInteresAdapter(ArrayList<Monumento> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PuntoInteresViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_monumento, parent, false);
        PuntoInteresViewHolder vh = new PuntoInteresViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PuntoInteresViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position).toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public  void onItemClick(View v,int i){
        Toast.makeText(v.getContext(),"Click: "+mDataset.get(i).toString(), Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putString("nombre", mDataset.get(i).toString());
        //Navigation.findNavController(view).navigate(R.id.confirmationAction, bundle);

        Navigation.findNavController(v).navigate(R.id.action_nav_puntos_interes_to_nav_detalle_monumento,bundle);


    }


}