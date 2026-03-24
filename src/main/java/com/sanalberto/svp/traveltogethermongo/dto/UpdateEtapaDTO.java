package com.sanalberto.svp.traveltogethermongo.dto;

import java.util.ArrayList;

public class UpdateEtapaDTO {
    private String nombreViaje;
    private ArrayList<NewEtapaDTO> newEtapas;

    public UpdateEtapaDTO() {}

    public UpdateEtapaDTO(String nombreViaje, ArrayList<NewEtapaDTO> newEtapas) {
        this.nombreViaje = nombreViaje;
        this.newEtapas = newEtapas;
    }

    public String getNombreViaje() {
        return nombreViaje;
    }

    public void setNombreViaje(String nombreViaje) {
        this.nombreViaje = nombreViaje;
    }

    public ArrayList<NewEtapaDTO> getNewEtapas() {
        return newEtapas;
    }

    public void setNewEtapas(ArrayList<NewEtapaDTO> newEtapas) {
        this.newEtapas = newEtapas;
    }

    @Override
    public String toString() {
        return "UpdateEtapaDTO{" +
            ", updateEtapasArrayList=" + newEtapas +
            '}';
    }
}
