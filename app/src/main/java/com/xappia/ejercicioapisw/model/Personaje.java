package com.xappia.ejercicioapisw.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Personaje implements Serializable {

    private String name;
    @SerializedName("height")
    private String altura;
    @SerializedName("hair_color")
    private String colPelo;
    @SerializedName("skin_color")
    private String colPiel;
    @SerializedName("eye_color")
    private String colOjos;
    @SerializedName("gender")
    private String genero;
    private Films pelicula;
    private String homeworld;
    private List<String> species;


    public String getName() {
        return name;
    }

    public String getAltura() {
        return altura;
    }

    public String getColPelo() {
        return colPelo;
    }

    public String getColPiel() {
        return colPiel;
    }

    public String getColOjos() {
        return colOjos;
    }

    public String getGenero() {
        return genero;
    }

    public Films getPelicula() {
        return pelicula;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public List<String> getSpecies() {
        return species;
    }


}
