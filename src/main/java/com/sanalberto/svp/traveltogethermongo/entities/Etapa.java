package com.sanalberto.svp.traveltogethermongo.entities;


import org.bson.types.ObjectId;

public class Etapa {

    private ObjectId idDestino;
    private String alias_destino;
    private String nombreDestino;
    private String horaInicio;
    private Integer duracionMinutos;

    public Etapa() {}

    public Etapa(ObjectId idDestino, String alias_destino, String nombreDestino, String horaInicio, Integer duracionMinutos) {
        this.idDestino = idDestino;
        this.alias_destino = alias_destino;
        this.nombreDestino = nombreDestino;
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
    }

    public Etapa(String alias_destino, String nombreDestino, String horaInicio, Integer duracionMinutos) {
        this.alias_destino = alias_destino;
        this.nombreDestino = nombreDestino;
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
    }

    public ObjectId getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(ObjectId idDestino) {
        this.idDestino = idDestino;
    }

    public String getAliasDestino() {return alias_destino;}

    public void setAliasDestino(String aliasDestino) {this.alias_destino = aliasDestino;}

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
}
