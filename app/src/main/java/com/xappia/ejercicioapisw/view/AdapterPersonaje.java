package com.xappia.ejercicioapisw.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xappia.ejercicioapisw.R;
import com.xappia.ejercicioapisw.model.Personaje;

import java.util.List;

public class AdapterPersonaje extends RecyclerView.Adapter<AdapterPersonaje.ViewHolderPersonaje> {

    private List<Personaje> personajeList;
    private ListenerDeAdapter listenerDeAdapter;

    public AdapterPersonaje(List<Personaje> personajeList) {
        this.personajeList = personajeList;
    }

    public AdapterPersonaje(ListenerDeAdapter listenerDeAdapter) {
        this.listenerDeAdapter = listenerDeAdapter;
    }

    @NonNull
    @Override
    public ViewHolderPersonaje onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_personaje,parent,false);
        return new ViewHolderPersonaje(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonaje holder, int position) {
        Personaje personajeAMostrar = personajeList.get(position);
        holder.cargarPersonaje(personajeAMostrar);
    }

    @Override
    public int getItemCount() {
        return personajeList.size();
    }

    public void setPersonajeList(List<Personaje> articuloList) {
        this.personajeList = personajeList;
        notifyDataSetChanged();
    }

    public void agregarPersonaje(Personaje personaje){
        personajeList.add(personaje);
        notifyDataSetChanged();
    }

    public class ViewHolderPersonaje extends RecyclerView.ViewHolder {

        private TextView nombrePersonaje, numeroPersonaje;

        public ViewHolderPersonaje(@NonNull View itemView) {
            super(itemView);
            nombrePersonaje = itemView.findViewById(R.id.CeldaPersonaje_TextView_NombrePersonaje);
            numeroPersonaje = itemView.findViewById(R.id.CeldaPersonaje_TextView_NumeroPersonaje);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Personaje personajeSeleccionado = personajeList.get(getAdapterPosition());
                    listenerDeAdapter.informarPersonajeSeleccionado(personajeSeleccionado);
                }
            });
        }

        public void cargarPersonaje(Personaje personaje){
            nombrePersonaje.setText(personaje.getName());
            numeroPersonaje.setText(personaje.hashCode());
        }
    }

    public interface ListenerDeAdapter{
        public void informarPersonajeSeleccionado(Personaje personaje);
    }
}
