package com.sanalberto.svp.traveltogethermongo.dto;

import com.sanalberto.svp.traveltogethermongo.entities.Etapa;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class UpdateEtapaDTO {
    private ObjectId id;
    private ArrayList<Etapa> updateEtapasArrayList;

    public UpdateEtapaDTO() {}

    public UpdateEtapaDTO(ObjectId id, ArrayList<Etapa> updateEtapasArrayList) {
        this.id = id;
        this.updateEtapasArrayList = updateEtapasArrayList;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
            "id=" + id +
            ", updateEtapasArrayList=" + updateEtapasArrayList +
            '}';
    }
}
