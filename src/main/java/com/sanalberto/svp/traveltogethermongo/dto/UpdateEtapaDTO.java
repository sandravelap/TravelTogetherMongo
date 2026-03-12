package com.sanalberto.svp.traveltogethermongo.dto;

import com.sanalberto.svp.traveltogethermongo.entities.Etapa;

import java.util.ArrayList;

public class UpdateEtapaDTO {
    private String nameViaje;
    private ArrayList<Etapa> updateEtapasArrayList;

    public UpdateEtapaDTO() {}

    public UpdateEtapaDTO(String nameViaje, ArrayList<Etapa> updateEtapasArrayList) {
        this.nameViaje = nameViaje;
        this.updateEtapasArrayList = updateEtapasArrayList;
    }

    public String getNameViaje() {
        return nameViaje;
    }

    public void setNameViaje(String nameViaje) {
        this.nameViaje = nameViaje;
    }

    public ArrayList<Etapa> getUpdateEtapasArrayList() {
        return updateEtapasArrayList;
    }

    public void setUpdateEtapasArrayList(ArrayList<Etapa> updateEtapasArrayList) {
        this.updateEtapasArrayList = updateEtapasArrayList;
    }

    @Override
    public String toString() {
        return "UpdateEtapaDTO{" +
            "id=" + nameViaje +
            ", updateEtapasArrayList=" + updateEtapasArrayList +
            '}';
    }
}
