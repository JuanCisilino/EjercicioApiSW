package com.xappia.ejercicioapisw.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("/api/people/{id}")
    Call<Personaje> traerPersonaje(@Path("id") Integer numeroPersonaje);
}
