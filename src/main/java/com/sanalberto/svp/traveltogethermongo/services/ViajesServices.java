package com.sanalberto.svp.traveltogethermongo.services;

import com.sanalberto.svp.traveltogethermongo.dto.NewViajeDTO;
import com.sanalberto.svp.traveltogethermongo.dto.ViajeDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Viaje;
import com.sanalberto.svp.traveltogethermongo.repositories.ViajesRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ViajesServices {
    private ViajesRepo viajesRepo = new ViajesRepo();

    public ArrayList<ViajeDTO> mostrarViajes(){
        ArrayList<ViajeDTO> viajes = new ArrayList<>();
        ViajeDTO viajeDTO;
        List<Viaje> viajesDAO = viajesRepo.getViajes();
        for (Viaje viaje: viajesDAO) {
            viajeDTO = new ViajeDTO();
            viajeDTO.setNombre(viaje.getNombre());
            viajeDTO.setDescripcion(viaje.getDescripcion());
            viajeDTO.setMaxParticipantes(viaje.getMaxParticipantes());
            viajeDTO.setFechaInicio(viaje.getFecha_inicio().toLocalDate());
            viajeDTO.setFechaFin(viaje.getFecha_fin().toLocalDate());
            viajeDTO.setTabaco(viaje.isTabaco());
            viajeDTO.setMascota(viaje.getMascota());
            viajes.add(viajeDTO);
        }
        return viajes;
    }

    public String createParseViaje(NewViajeDTO inputViajeDTO){
        List<String> mascotasOptions = List.of("todas", "asistencia", "no");
        String output = "";
        Viaje viajeDAO = new Viaje();

        // todo: validar el token.

        // Se validan las mascotas para que concuerden con las opciones establecidas (todas, tolerante, ninguna, null).
        if(mascotasOptions.contains(viajeDAO.getMascota().toLowerCase())){
            viajeDAO.setNombre(inputViajeDTO.getNombre());
            viajeDAO.setDescripcion(inputViajeDTO.getDescripcion());

            // fixme: get _id, aliasCreador, etapas and participantes.
            // Se añade como hora la medianoche (00:00:00).
            viajeDAO.setFecha_inicio(inputViajeDTO.getDiaInicio().atStartOfDay());
            viajeDAO.setFecha_fin(inputViajeDTO.getDiaFin().atStartOfDay());
            viajeDAO.setTabaco(inputViajeDTO.getTabaco());
            viajeDAO.setMascota(inputViajeDTO.getMascota());

            output = viajesRepo.insertNewViaje(viajeDAO);
        }
        else{
            output = "MONGO >> No se ha podido guardar el nuevo viaje, el campo mascotas debe ser \"TODAS\", \"ASISTENCIA\" o \"NO\".";
        }

        return output;
    }
}