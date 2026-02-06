package com.sanalberto.svp.traveltogethermongo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sanalberto.svp.traveltogethermongo.dto.CercanosDTO;
import com.sanalberto.svp.traveltogethermongo.dto.DestinoDTO;
import com.sanalberto.svp.traveltogethermongo.services.CercanosServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cercanos")
public class CercanosResource {
    @OPTIONS
    @Path("{path: .*}")
    public Response options() {
        return Response.ok().build();
    }

    private CercanosServices cercanosServices = new CercanosServices();


    @GET


    @Produces(MediaType.APPLICATION_JSON)
    //Utilizamos BeanParam para pasar un DTO mapeado y no los parámetros sueltos
    public String getCercanos(@BeanParam CercanosDTO cercanosDTO){
        String respuesta = "";
        // Crea el constructor de parseadores gson.
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Crea el gson con la opción de indentar correctamente al generarlo.
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        List<DestinoDTO> listaDestinos = cercanosServices.getCercanos(cercanosDTO);
        respuesta = gson.toJson(listaDestinos);
        return respuesta;

    }
}
