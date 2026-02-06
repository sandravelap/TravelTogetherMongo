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
        String output = "";
        Viaje viajeDAO = new Viaje();

        // todo: validar mascotas (todas, tolerante, ninguna, null)

        LocalDateTime parsedLocalDateFechaInicio = LocalDateTime.of(inputViajeDTO.getDiaInicio().getYear(), inputViajeDTO.getDiaInicio().getMonthValue(), inputViajeDTO.getDiaInicio().getDayOfMonth(), 0, 0, 0);
        LocalDateTime parsedLocalDateFechaFin = LocalDateTime.of(inputViajeDTO.getDiaFin().getYear(), inputViajeDTO.getDiaFin().getMonthValue(), inputViajeDTO.getDiaFin().getDayOfMonth(), 0, 0, 0);

        // fixme: get _id, aliasCreador, etapas and participantes.
        viajeDAO.setNombre(inputViajeDTO.getNombre());
        viajeDAO.setDescripcion(inputViajeDTO.getDescripcion());
        viajeDAO.setFecha_inicio(parsedLocalDateFechaInicio);
        viajeDAO.setFecha_fin(parsedLocalDateFechaFin);
        viajeDAO.setTabaco(inputViajeDTO.getTabaco());
        viajeDAO.setMascota(inputViajeDTO.getMascota());

        return output;
    }
}