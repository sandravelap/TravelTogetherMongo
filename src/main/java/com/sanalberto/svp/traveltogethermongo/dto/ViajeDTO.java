package com.sanalberto.svp.traveltogethermongo.dto;

public class ViajeDTO {
    private String nombre;
    private String descripcion;

    // Constructor, Getters y Setters
    public ViajeDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ViajeDTO() {
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
