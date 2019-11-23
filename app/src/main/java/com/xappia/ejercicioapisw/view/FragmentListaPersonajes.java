package com.xappia.ejercicioapisw.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xappia.ejercicioapisw.R;
import com.xappia.ejercicioapisw.model.Personaje;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaPersonajes extends Fragment implements AdapterPersonaje.ListenerDeAdapter{

    public RecyclerView contenedorLista;
    private ListenerDeFragment listenerDeFragment;
    private AdapterPersonaje adapterPersonaje;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_personajes, container, false);
        contenedorLista = view.findViewById(R.id.MainActivity_RecyclerView_ContenedorDeLista);
        adapterPersonaje = new AdapterPersonaje(this);
        contenedorLista.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        contenedorLista.setAdapter(adapterPersonaje);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDeFragment = (ListenerDeFragment) context;
    }

    public void agregarPersonaje(Personaje personaje){
        adapterPersonaje.agregarPersonaje(personaje);
    }


    @Override
    public void informarPersonajeSeleccionado(Personaje personaje) {

    }

    public interface ListenerDeFragment {
        public void recibirPersonaje(Personaje personaje);



    }
}
