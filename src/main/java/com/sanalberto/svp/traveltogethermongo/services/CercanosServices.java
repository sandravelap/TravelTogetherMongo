package com.sanalberto.svp.traveltogethermongo.services;

import com.sanalberto.svp.traveltogethermongo.dto.CercanosDTO;
import com.sanalberto.svp.traveltogethermongo.dto.DestinoDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Destino;
import com.sanalberto.svp.traveltogethermongo.repositories.CercanosRepo;

import java.util.ArrayList;
import java.util.List;

public class CercanosServices {

    private CercanosRepo cercanosRepo = new CercanosRepo();

    public ArrayList<DestinoDTO> getCercanos(CercanosDTO cercanosDTO) {

        ArrayList<DestinoDTO> destinos = new ArrayList<>();

        DestinoDTO destinoDTO;
        List<Destino> destinoDAO = cercanosRepo.getCercanos(cercanosDTO);
        for (Destino destino : destinoDAO) {
            destinoDTO = new DestinoDTO();
            destinoDTO.setNombre(destino.getNombre());
            destinoDTO.setDescripcion(destino.getDescripcion());
            destinoDTO.setAlias_destino(destino.getAlias_destino());
            destinoDTO.setDificultad(destino.getDificultad());

            destinos.add(destinoDTO);
        }
        return destinos;
    }


}

