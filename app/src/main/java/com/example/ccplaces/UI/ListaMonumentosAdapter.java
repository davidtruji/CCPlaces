package com.example.ccplaces.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.R;

import java.util.List;

public class ListaMonumentosAdapter extends  RecyclerView.Adapter<ListaMonumentosAdapter.PuntoInteresViewHolder> {



     class PuntoInteresViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreMonumento;
        private final ImageView imgMonumento;

        private PuntoInteresViewHolder(View itemView) {
            super(itemView);
            nombreMonumento = itemView.findViewById(R.id.tv_nombre_monumento);
            imgMonumento=itemView.findViewById(R.id.imgMonumento);
        }

    }

    private final LayoutInflater mInflater;
    private List<Monumento> mMonumentos; // Cached copy of words

    ListaMonumentosAdapter(Context context) { mInflater = LayoutInflater.from(context); }

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
            holder.imgMonumento.setImageResource(current.getImgId());
        } else {
            // Covers the case of data not being ready yet.
            holder.nombreMonumento.setText("No Monumento");
        }
    }

    void setMonumentos(List<Monumento> monumentos){
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