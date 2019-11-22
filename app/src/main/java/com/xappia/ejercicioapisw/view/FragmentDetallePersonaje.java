package com.xappia.ejercicioapisw.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xappia.ejercicioapisw.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePersonaje extends Fragment {

    private TextView nombrePersonaje, alturaPersonaje, colPeloPersonaje, colPielPersonaje, colOjoPersonaje, generoPersonaje;
    private TextView nombreHome, climaHome, gravedadHome, terrenoHome, poblacionHome;
    private TextView nombreEspecie, clasifEspecie, altPromEspecie, promVidaEspecie, idiomaEspecie;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detalle_personaje, container, false);


        return view;
    }

    public void buscarVariablesPersonaje() {
        nombrePersonaje = view.findViewById(R.id.FragmentDetalle_TextView_NombredePersonaje);
        alturaPersonaje = view.findViewById(R.id.FragmentDetalle_TextView_AlturadePersonaje);
        colPeloPersonaje = view.findViewById(R.id.FragmentDetalle_TextView_ColPeloPersonaje);
        colPielPersonaje = view.findViewById(R.id.FragmentDetalle_TextView_ColPielPersonaje);
        colOjoPersonaje = view.findViewById(R.id.FragmentDetalle_TextView_ColOjosPersonaje);
        generoPersonaje = view.findViewById(R.id.FragmentDetalle_TextView_GeneroPersonaje);
    }

    public void buscarVariablesHome() {
        nombreHome = view.findViewById(R.id.homeworld_TextView_nombrePlaneta);
        climaHome = view.findViewById(R.id.homeworld_TextView_climaPlaneta);
        gravedadHome = view.findViewById(R.id.homeworld_TextView_gravedadPlaneta);
        terrenoHome = view.findViewById(R.id.homeworld_TextView_terrenoPlaneta);
        poblacionHome = view.findViewById(R.id.homeworld_TextView_poblacionPlaneta);
    }

    public void buscarVariablesEspecie(){
        nombreEspecie = view.findViewById(R.id.especie_TextView_nombreEspecie);
        clasifEspecie = view.findViewById(R.id.especie_TextView_clasifEspecie);
        altPromEspecie = view.findViewById(R.id.especie_TextView_altpromEspecie);
        promVidaEspecie = view.findViewById(R.id.especie_TextView_promvidEspecie);
        idiomaEspecie = view.findViewById(R.id.especie_TextView_idiomaEspecie);
    }


}
