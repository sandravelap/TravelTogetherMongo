package com.sanalberto.svp.traveltogethermongo.dto;

import java.time.LocalDate;

public class ViajeDTO {
    private String nombre;
    private String descripcion;
    private Integer maxParticipantes;
    // El mejor reemplazo para ISODate("...") de MongoDB
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean tabaco;
    private String mascota;

    // Constructor, Getters y Setters
    public ViajeDTO(String nombre, String descripcion, Integer maxParticipantes, LocalDate fechaInicio, LocalDate fechaFin, boolean tabaco, String mascota) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.maxParticipantes = maxParticipantes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tabaco = tabaco;
        this.mascota = mascota;
    }

    public ViajeDTO() {
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

    public Integer getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(Integer maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isTabaco() {
        return tabaco;
    }

    public void setTabaco(boolean tabaco) {
        this.tabaco = tabaco;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
}
