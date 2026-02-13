package com.sanalberto.svp.traveltogethermongo.dto;

import java.time.LocalDate;

public class NewViajeDTO {
    private LocalDate diaInicio;
    private LocalDate diaFin;
    private Integer numero_participantes;
    private String nombre;
    private String descripcion;
    private Boolean tabaco;
    private String mascota;

    public NewViajeDTO() {}

    public NewViajeDTO(LocalDate diaInicio, LocalDate diaFin, Integer numero_participantes, String nombre, String descripcion, Boolean tabaco, String mascota) {
        this.diaInicio = diaInicio;
        this.diaFin = diaFin;
        this.numero_participantes = numero_participantes;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tabaco = tabaco;
        this.mascota = mascota;
    }

    public LocalDate getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(LocalDate diaInicio) {
        this.diaInicio = diaInicio;
    }

    public LocalDate getDiaFin() {
        return diaFin;
    }

    public void setDiaFin(LocalDate diaFin) {
        this.diaFin = diaFin;
    }

    public Integer getNumero_participantes() {
        return numero_participantes;
    }

    public void setNumero_participantes(Integer numero_participantes) {
        this.numero_participantes = numero_participantes;
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

    public Boolean getTabaco() {
        return tabaco;
    }

    public void setTabaco(Boolean tabaco) {
        this.tabaco = tabaco;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "NewViajeDTO{" +
            "diaInicio=" + diaInicio +
            ", diaFin=" + diaFin +
            ", numero_participantes=" + numero_participantes +
            ", nombre='" + nombre + '\'' +
            ", descripcion='" + descripcion + '\'' +
            ", tabaco=" + tabaco +
            ", mascota='" + mascota + '\'' +
            '}';
    }
}
