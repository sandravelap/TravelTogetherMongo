package com.sanalberto.svp.traveltogethermongo.entities;


public class Recomendacion {

    private String nombre;
    private Double descuento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
}
