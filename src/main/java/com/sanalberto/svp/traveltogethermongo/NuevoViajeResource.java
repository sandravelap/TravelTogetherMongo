package com.sanalberto.svp.traveltogethermongo;

import com.google.gson.Gson;
import com.sanalberto.svp.traveltogethermongo.dto.NewViajeDTO;
import com.sanalberto.svp.traveltogethermongo.services.ViajesServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/NuevoViaje")
public class NuevoViajeResource {

    private ViajesServices insertViajesServices = new ViajesServices();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String guardarNuevoViaje(String jsonInput){
        String output = "";

        NewViajeDTO newViajeDto = new Gson().fromJson(jsonInput, NewViajeDTO.class);
        output = String.valueOf(insertViajesServices.createParseViaje(newViajeDto));

        return output;
    }
}
