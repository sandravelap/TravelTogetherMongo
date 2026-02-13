package com.sanalberto.svp.traveltogethermongo.dto;

public class DestinoDTO {
    private String alias_destino;
    private String descripcion;
    private int dificultad;
    private String nombre;

    public DestinoDTO() {
    }

    public DestinoDTO(String alias_destino, String descripcion, int dificultad, String nombre) {
        this.alias_destino = alias_destino;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.nombre = nombre;
    }

    public String getAlias_destino() {
        return alias_destino;
    }

    public void setAlias_destino(String alias_destino) {
        this.alias_destino = alias_destino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
