package com.sanalberto.svp.traveltogethermongo.services;

import com.sanalberto.svp.traveltogethermongo.dto.ViajeDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Viaje;
import com.sanalberto.svp.traveltogethermongo.repositories.ViajesRepo;

import java.util.ArrayList;
import java.util.List;

public class ViajesServices {
    private ViajesRepo viajesRepo = new ViajesRepo();

    public ArrayList<ViajeDTO> mostrarViajes(){
        ArrayList<ViajeDTO> viajes = new ArrayList<>();
        ViajeDTO viajeDTO;
        List<Viaje> viajesDAO = viajesRepo.getViajes();
        for (Viaje viaje : viajesDAO) {
            viajeDTO = new ViajeDTO();
            viajeDTO.setNombre(viaje.getNombre());
            viajeDTO.setDescripcion(viaje.getDescripcion());
            viajes.add(viajeDTO);
        }
        return viajes;
    }
}