package com.sanalberto.svp.traveltogethermongo.entities;


import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;


public class Viaje {

    private ObjectId _id;
    private String aliasCreador;
    private String nombre;
    private String descripcion;
    private int maxParticipantes;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private boolean tabaco;
    private String mascota;

    // Relación N:M simplificada: Lista de IDs de usuarios participantes
    private List<String> aliasParticipantes;

    // Relación 1:N embebida: Lista de objetos Etapa
    private List<Etapa> etapas;

    public Viaje() {}

    public Viaje(ObjectId _id, String aliasCreador, String nombre, String descripcion, int maxParticipantes, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, boolean tabaco, String mascota, List<String> aliasParticipantes, List<Etapa> etapas) {
        this._id = _id;
        this.aliasCreador = aliasCreador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.maxParticipantes = maxParticipantes;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tabaco = tabaco;
        this.mascota = mascota;
        this.aliasParticipantes = aliasParticipantes;
        this.etapas = etapas;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getAliasCreador() {
        return aliasCreador;
    }

    public void setAliasCreador(String aliasCreador) {
        this.aliasCreador = aliasCreador;
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

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
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

    public List<String> getAliasParticipantes() {
        return aliasParticipantes;
    }

    public void setAliasParticipantes(List<String> aliasParticipantes) {
        this.aliasParticipantes = aliasParticipantes;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }
}
