package com.xappia.ejercicioapisw.model;

import android.nfc.cardemulation.CardEmulation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface Service {

    @GET("/api/people/{id}")
    Call<Personaje> traerPersonaje(@Path("id") Integer numeroPersonaje);

    @GET()
    Call<Homeworld> traerHomeworld(@Url() String urlHomeworld);

    @GET()
    Call<Species> traerSpecie(@Url() String urlSpecie);
}
