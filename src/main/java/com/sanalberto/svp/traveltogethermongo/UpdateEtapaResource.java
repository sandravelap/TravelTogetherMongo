package com.sanalberto.svp.traveltogethermongo;

import com.google.gson.*;
import com.sanalberto.svp.traveltogethermongo.dto.UpdateEtapaDTO;
import com.sanalberto.svp.traveltogethermongo.services.ViajesServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/updateEtapa")
public class UpdateEtapaResource {

    private ViajesServices updateViajesServices = new ViajesServices();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @JwtTokenNeeded
    public String updateEtapa(@Context SecurityContext securityContext, String jsonInput){
        String output = "";
        String alias = securityContext.getUserPrincipal().getName();

        Gson gson = new Gson();

        UpdateEtapaDTO newEtapaDto = gson.fromJson(jsonInput, UpdateEtapaDTO.class);

        // Al final se ha modificado el recurso para que actualice en la base de datos utilizando el nombre del viaje como referencia.
        output = updateViajesServices.updateEtapas(alias, newEtapaDto.getNombreViaje(), newEtapaDto);

        return output;
    }
}
