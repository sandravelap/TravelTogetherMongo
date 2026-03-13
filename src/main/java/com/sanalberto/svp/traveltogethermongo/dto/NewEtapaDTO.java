package com.sanalberto.svp.traveltogethermongo.dto;

public class NewEtapaDTO {
    private String aliasDestino;
    private String nombreDestino;
    private String horaInicio;
    private Integer duracionMinutos;

    public NewEtapaDTO() {}

    public NewEtapaDTO(String aliasDestino, String nombreDestino, String horaInicio, Integer duracionMinutos) {
        this.aliasDestino = aliasDestino;
        this.nombreDestino = nombreDestino;
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
    }

    public String getAliasDestino() {
        return aliasDestino;
    }

    public void setAliasDestino(String aliasDestino) {
        this.aliasDestino = aliasDestino;
    }

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
