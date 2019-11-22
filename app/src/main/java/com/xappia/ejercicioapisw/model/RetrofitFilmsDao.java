package com.xappia.ejercicioapisw.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFilmsDao {

    private Retrofit retrofit;
    protected Service service;

    public RetrofitFilmsDao(String baseURL) {


        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);

    }
}
