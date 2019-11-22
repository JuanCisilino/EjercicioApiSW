package com.xappia.ejercicioapisw.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.xappia.ejercicioapisw.R;
import com.xappia.ejercicioapisw.model.Films;
import com.xappia.ejercicioapisw.model.Personaje;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilms extends RecyclerView.Adapter<AdapterFilms.ViewHolderFilms> {

    private List<Films> filmsList;
    private ListenerDeAdapter listenerDeAdapter;

    public AdapterFilms(List<Films> filmsList) {
        this.filmsList = new ArrayList<>();
    }

    public AdapterFilms(ListenerDeAdapter listenerDeAdapter) {
        this.listenerDeAdapter = listenerDeAdapter;
    }

    @NonNull
    @Override
    public ViewHolderFilms onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_pelicula,parent,false);
        return new ViewHolderFilms(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFilms holder, int position) {
        Films filmAMostrar = filmsList.get(position);
        holder.cargarProducto(filmAMostrar);
    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }

    public void setFilmsList(List<Films> filmsList) {
        this.filmsList = filmsList;
        notifyDataSetChanged();
    }

    public class ViewHolderFilms extends RecyclerView.ViewHolder{

        private TextView tituloPelicula, directorPelicula, fechaLanzPelicula;

        public ViewHolderFilms(@NonNull View itemView) {
            super(itemView);
            tituloPelicula = itemView.findViewById(R.id.celdapelicula_TextView_nombrePelicula);
            directorPelicula = itemView.findViewById(R.id.celdapelicula_TextView_directorPelicula);
            fechaLanzPelicula = itemView.findViewById(R.id.celdapelicula_TextView_fechaestrenoPelicula);
        }

        public void cargarProducto(Films films){
            tituloPelicula.setText(films.getTitle());
            directorPelicula.setText(films.getDirector());
            fechaLanzPelicula.setText(films.getRelease_date());
        }
    }

    public interface ListenerDeAdapter {
        public void informarArticuloSeleccionado(Personaje personaje);
    }
}


