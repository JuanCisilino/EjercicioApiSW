package com.xappia.ejercicioapisw.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xappia.ejercicioapisw.R;
import com.xappia.ejercicioapisw.controller.ControllerFilms;
import com.xappia.ejercicioapisw.model.Personaje;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePersonaje extends Fragment implements AdapterFilms.ListenerDeAdapter{

    public static final String PERSONAJEELEGIDO = "PersonajeElegido";
    private TextView nombrePersonaje, alturaPersonaje, colPeloPersonaje, colPielPersonaje, colOjoPersonaje, generoPersonaje;
    private TextView nombreHome, climaHome, gravedadHome, terrenoHome, poblacionHome;
    private TextView nombreEspecie, clasifEspecie, altPromEspecie, promVidaEspecie, idiomaEspecie;
    private View view;
    private Personaje personajeElegido;
    private AdapterFilms adapterFilms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detalle_personaje, container, false);
        buscarVariablesPersonaje();
        buscarVariablesHome();
        buscarVariablesEspecie();
        Bundle bundle = getArguments();
        personajeElegido = (Personaje) bundle.getSerializable(PERSONAJEELEGIDO);
        adapterFilms = new AdapterFilms(this);
        ControllerFilms controllerFilms = new ControllerFilms();
        setearPersonaje();
//        setearHome();
//        setearEspecie();
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

    public void setearPersonaje(){
        nombrePersonaje.setText(personajeElegido.getName());
        alturaPersonaje.setText("Altura: " + personajeElegido.getAltura());
        colPeloPersonaje.setText("Color de Pelo: " + personajeElegido.getColPelo());
        colPielPersonaje.setText("Color de Piel: " + personajeElegido.getColPiel());
        colOjoPersonaje.setText("Color de Ojos: " + personajeElegido.getColOjos());
        generoPersonaje.setText("Genero: " + personajeElegido.getGenero());
    }

    public void setearHome() {
       nombreHome.setText("Planeta: " + personajeElegido.getHogar().getName());
       climaHome.setText("Clima: " + personajeElegido.getHogar().getClimate());
       gravedadHome.setText("Gravedad: " + personajeElegido.getHogar().getGravity());
       terrenoHome.setText("Terreno: " + personajeElegido.getHogar().getTerrain());
       poblacionHome.setText("Poblacion: " + personajeElegido.getHogar().getPopulation());
    }

    public void setearEspecie() {
        nombreEspecie.setText("Especie: " + personajeElegido.getEspecie().getName());
        clasifEspecie.setText("Clasificacion: " + personajeElegido.getEspecie().getClassification());
        altPromEspecie.setText("Altura Promedio: " + personajeElegido.getEspecie().getAverage_height());
        promVidaEspecie.setText("Promedio de Vida: " + personajeElegido.getEspecie().getAverage_lifespan());
        idiomaEspecie.setText("Idioma: " + personajeElegido.getEspecie().getLanguage());
    }

    @Override
    public void informarArticuloSeleccionado(Personaje personaje) {

    }
}
