package com.sanalberto.svp.traveltogethermongo.entities;


import org.bson.types.ObjectId;

import java.util.List;


public class Destino {


    private ObjectId id;

    private String alias_destino;

    private String nombre;

    private String descripcion;

    private Ubicacion ubicacion;

    private int dificultad;

    private List<Recomendacion> recomendaciones;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAlias_destino() {return alias_destino;}

    public void setAlias_destino(String alias_destino) {
        this.alias_destino = alias_destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public List<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
}
