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

    public String createParseViaje(String alias, NewViajeDTO inputViajeDTO){
        List<String> mascotasOptions = List.of("TODAS", "ASISTENCIA", "NO");
        String output = "";
        Viaje viajeDAO = new Viaje();

        // Se validan las mascotas para que concuerden con las opciones establecidas (todas, asistencia, no, null).
        if(mascotasOptions.contains(inputViajeDTO.getMascota().toUpperCase())){

            // todo: get _id, etapas and participantes.
            // viajeDAO.set_id(10001);
            viajeDAO.setAliasCreador(alias);
            viajeDAO.setNombre(inputViajeDTO.getNombre());
            viajeDAO.setDescripcion(inputViajeDTO.getDescripcion());

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