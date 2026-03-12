package com.sanalberto.svp.traveltogethermongo;


import com.sanalberto.svp.traveltogethermongo.dto.UpdateUserDTO;
import com.sanalberto.svp.traveltogethermongo.services.UpdateUserServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

import java.util.Map;

@Path("/updateUser")
public class UpdateUserResource {
    @OPTIONS
    @Path("{path: .*}")
    public Response options() {
        return Response.ok().build();
    }
    private UpdateUserServices updateUserServices = new  UpdateUserServices();
    @POST


    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JwtTokenNeeded
    public Response insert (UpdateUserDTO updateUserDTO, @Context SecurityContext securityContext) {
        String alias = securityContext.getUserPrincipal().getName();
        String respuesta = updateUserServices.update(updateUserDTO, alias);
        return Response.ok(Map.of("respuesta", respuesta)).build();
    }
}
