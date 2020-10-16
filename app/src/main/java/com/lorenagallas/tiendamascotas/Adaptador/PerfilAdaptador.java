package com.lorenagallas.tiendamascotas.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.lorenagallas.tiendamascotas.POJO.Mascota;
import com.lorenagallas.tiendamascotas.POJO.Perfil;
import com.lorenagallas.tiendamascotas.R;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {
    ArrayList<Perfil> fotos;

    public PerfilAdaptador(ArrayList<Perfil> fotos) {
        this.fotos = fotos;
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvLike;
        private ImageButton btnLink;


        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto  = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLike   = (TextView) itemView.findViewById(R.id.tvlikeCV);
            btnLink  = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false); //asocia layout con RecyclerView
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder perfilViewHolder, int position) {
        final Perfil perfil = fotos.get(position);

        perfilViewHolder.imgFoto.setImageResource(perfil.getFotoPerfil());
        perfilViewHolder.tvLike.setText(perfil.getLike());

       perfilViewHolder.btnLink.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               perfil.setLike(perfil.getLike()+1);
               notifyDataSetChanged();
           }
        });
    }


    @Override
    public int getItemCount() {

        return fotos.size();
    }
}