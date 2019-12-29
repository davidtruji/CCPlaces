package com.example.ccplaces.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.R;

import java.util.List;

public class PuntoInteresAdapter extends  RecyclerView.Adapter<PuntoInteresAdapter.PuntoInteresViewHolder> {



    class PuntoInteresViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreMonumento;

        private PuntoInteresViewHolder(View itemView) {
            super(itemView);
            nombreMonumento = itemView.findViewById(R.id.tv_nombre_monumento);
        }
    }

    private final LayoutInflater mInflater;
    private List<Monumento> mMonumentos; // Cached copy of words

    PuntoInteresAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public PuntoInteresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_list_monumento, parent, false);
        return new PuntoInteresViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PuntoInteresViewHolder holder, int position) {
        if (mMonumentos != null) {
            Monumento current = mMonumentos.get(position);
            holder.nombreMonumento.setText(current.getNombre());
        } else {
            // Covers the case of data not being ready yet.
            holder.nombreMonumento.setText("No Monumento");
        }
    }

    void setWords(List<Monumento> monumentos){
        mMonumentos = monumentos;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mMonumentos != null)
            return mMonumentos.size();
        else return 0;
    }


}