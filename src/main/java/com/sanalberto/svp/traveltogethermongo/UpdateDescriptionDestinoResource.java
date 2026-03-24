package com.sanalberto.svp.traveltogethermongo;

import com.google.gson.Gson;

import com.sanalberto.svp.traveltogethermongo.dto.DestinoDTO;
import com.sanalberto.svp.traveltogethermongo.services.DestinoServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/updateDestino")
public class UpdateDescriptionDestinoResource {
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String updateDestino(String jsonDestinoDTO) {
        String respuesta;
        try {
            Gson gson = new Gson();
            DestinoDTO destinoDTO = gson.fromJson(jsonDestinoDTO, DestinoDTO.class);

            DestinoServices destinoServices = new DestinoServices();
            respuesta = destinoServices.updateDestino(destinoDTO);

        } catch (Exception e) {
            respuesta="Algo falló"+ e.getMessage();
        }
        return respuesta;
    }
}