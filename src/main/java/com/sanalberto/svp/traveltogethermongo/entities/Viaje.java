package com.sanalberto.svp.traveltogethermongo.entities;


import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;


public class Viaje {

    private ObjectId id;
    private int idCreador;
    private String nombre;
    private String descripcion;
    private int participantesMax;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean tabaco;
    private String mascota;

    // Relación N:M simplificada: Lista de IDs de usuarios participantes
    private List<Integer> idParticipantes;

    // Relación 1:N embebida: Lista de objetos Etapa
    private List<Etapa> etapas;

    public Viaje() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getIdCreador() {
        return idCreador;
    }

    public void setIdCreador(int idCreador) {
        this.idCreador = idCreador;
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

    public int getParticipantesMax() {
        return participantesMax;
    }

    public void setParticipantesMax(int participantesMax) {
        this.participantesMax = participantesMax;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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

    public List<Integer> getIdParticipantes() {
        return idParticipantes;
    }

    public void setIdParticipantes(List<Integer> idParticipantes) {
        this.idParticipantes = idParticipantes;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }
}
