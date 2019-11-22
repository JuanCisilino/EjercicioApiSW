package com.xappia.ejercicioapisw.model;

import java.io.Serializable;

public class Personaje implements Serializable {

    private String name;
    private String altura;
    private String colPelo;
    private String colPiel;
    private String colOjos;
    private String genero;
    private Films pelicula;
    private Homeworld hogar;
    private Species especie;

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

    public Homeworld getHogar() {
        return hogar;
    }

    public Species getEspecie() {
        return especie;
    }
}
