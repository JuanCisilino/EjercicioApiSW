package com.xappia.ejercicioapisw.model;

import android.util.Log;

import com.xappia.ejercicioapisw.utils.ResultListener;
import com.xappia.ejercicioapisw.view.FragmentDetallePersonaje;

import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsDao extends RetrofitFilmsDao{

    public static final String NOMBRE = "Nombre";
    public static final String BASE_URL = "https://swapi.co";
    public static final String PERSONAJEELEGIDO = "PersonajeElegido";
    private Personaje personaje;
    List<Personaje> personajeList = new ArrayList<>();


    public FilmsDao() {
        super(BASE_URL);
    }

    public void traePersonaje(Integer PERSONAJEELEGIDO, final ResultListener<Personaje> listenerDelControler) {
        Call<Personaje> call = service.traerPersonaje(PERSONAJEELEGIDO);

        call.enqueue(new Callback<Personaje>() {
            @Override
            public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                personaje = response.body();
                listenerDelControler.finish(personaje);
            }

            @Override
            public void onFailure(Call<Personaje> call, Throwable t) {
                Log.d("","");
            }
        });
    }

    public void traerHomeworld(String homeworld, final ResultListener<Homeworld> listenerDelControler) {
        Call<Homeworld> call = service.traerHomeworld(homeworld);

        call.enqueue(new Callback<Homeworld>() {
            @Override
            public void onResponse(Call<Homeworld> call, Response<Homeworld> response) {
                Homeworld homeworld = response.body();
                listenerDelControler.finish(homeworld);
            }

            @Override
            public void onFailure(Call<Homeworld> call, Throwable t) {
                Log.d("","");
            }
        });
    }

    public void traerEspecie(String especie, final ResultListener<Species> listenerDelControler) {
        Call<Species> call = service.traerSpecie(especie);

        call.enqueue(new Callback<Species>() {
            @Override
            public void onResponse(Call<Species> call, Response<Species> response) {
                Species species = response.body();
                listenerDelControler.finish(species);
            }

            @Override
            public void onFailure(Call<Species> call, Throwable t) {
                Log.d("","");
            }
        });
    }


}
