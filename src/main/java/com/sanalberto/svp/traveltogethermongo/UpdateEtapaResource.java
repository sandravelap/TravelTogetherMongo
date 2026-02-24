package com.sanalberto.svp.traveltogethermongo;

import com.google.gson.*;
import com.sanalberto.svp.traveltogethermongo.dto.UpdateEtapaDTO;
import com.sanalberto.svp.traveltogethermongo.services.ViajesServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/updateEtapa")
public class UpdateEtapaResource {

    private ViajesServices updateViajesServices = new ViajesServices();

    // PUT o PATCH? (PUT -> modificaciones completas. PATCH -> modificaciones parciales)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    // todo: token needed?
    // @JwtTokenNeeded
    public String updateEtapa(String jsonInput){
        String output = "";

        Gson gson = new Gson();

        // todo: se puede combinar Mongo con Hibernate. Ver el POM para la dependencia y el enlace para más info.
        // https://www.mongodb.com/es/docs/languages/java/mongodb-hibernate/current/get-started/
        UpdateEtapaDTO newEtapaDto = gson.fromJson(jsonInput, UpdateEtapaDTO.class);
        output = updateViajesServices.updateEtapas(newEtapaDto);

        return output;
    }
}
