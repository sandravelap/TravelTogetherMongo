package com.sanalberto.svp.traveltogethermongo.services;

import com.sanalberto.svp.traveltogethermongo.dto.DestinoDTO;
import com.sanalberto.svp.traveltogethermongo.repositories.DestinoRepo;

public class DestinoServices {
    public String updateDestino (DestinoDTO destinoDTO){
        DestinoRepo destinoRepo = new DestinoRepo();
        String respuesta;
            if (destinoRepo.updateDestino(destinoDTO)) {
                respuesta = "Recomendación actualizada correctamente.";

            } else {
                respuesta = "No se encontró el destino.";
            }
        return respuesta;
    }
}
