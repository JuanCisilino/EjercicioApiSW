package com.xappia.ejercicioapisw.model;

import com.xappia.ejercicioapisw.utils.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsDao extends RetrofitFilmsDao{

    public static final String BASE_URL = "https://swapi.co";
    public static final String PERSONAJEELEGIDO = "PersonajeElegido";

    public FilmsDao() {
        super(BASE_URL);
    }

    public void traePersonaje(Integer PERSONAJEELEGIDO, final ResultListener<Personaje> listenerDelControler) {
        Call<Personaje> call = service.traerPersonaje(PERSONAJEELEGIDO);

        call.enqueue(new Callback<Personaje>() {
            @Override
            public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                Personaje personaje = response.body();
                listenerDelControler.finish(personaje);
            }

            @Override
            public void onFailure(Call<Personaje> call, Throwable t) {

            }
        });
    }
}
