package com.xappia.ejercicioapisw.controller;

import com.xappia.ejercicioapisw.model.Films;
import com.xappia.ejercicioapisw.model.FilmsDao;
import com.xappia.ejercicioapisw.model.Homeworld;
import com.xappia.ejercicioapisw.model.Personaje;
import com.xappia.ejercicioapisw.model.Species;
import com.xappia.ejercicioapisw.utils.ResultListener;

public class ControllerFilms {

    private FilmsDao filmsDao;

    public ControllerFilms() {
        filmsDao = new FilmsDao();
    }

    public void traePersonaje(Integer personajeElegido, final ResultListener<Personaje> listenerDeLaVista) {

        filmsDao.traePersonaje(personajeElegido, new ResultListener<Personaje>() {
            @Override
            public void finish(Personaje result) {
                listenerDeLaVista.finish(result);
            }

        });
    }

    public void traerHomeworld(String homeurl, final ResultListener<Homeworld> listenerDeLaVista) {
        filmsDao.traerHomeworld(homeurl, new ResultListener<Homeworld>() {
            @Override
            public void finish(Homeworld result) {
                listenerDeLaVista.finish(result);
            }
        });
    }

    public void traerEspecie(String especieurl, final ResultListener<Species> listenerDeLaVista) {
        filmsDao.traerEspecie(especieurl, new ResultListener<Species>() {
            @Override
            public void finish(Species result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}
