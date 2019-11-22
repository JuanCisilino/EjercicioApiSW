package com.xappia.ejercicioapisw.controller;

import com.xappia.ejercicioapisw.model.Films;
import com.xappia.ejercicioapisw.model.FilmsDao;
import com.xappia.ejercicioapisw.model.Personaje;
import com.xappia.ejercicioapisw.utils.ResultListener;

public class ControllerFilms {

    public void traePersonaje(Integer personajeElegido, final ResultListener<Personaje> listenerDeLaVista) {
        FilmsDao filmsDao = new FilmsDao();

        filmsDao.traePersonaje(personajeElegido, new ResultListener<Personaje>() {
            @Override
            public void finish(Personaje result) {
                listenerDeLaVista.finish(result);
            }

        });
    }
}
