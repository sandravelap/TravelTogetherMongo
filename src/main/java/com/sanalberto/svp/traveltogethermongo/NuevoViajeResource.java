package com.sanalberto.svp.traveltogethermongo;

import com.google.gson.*;
import com.sanalberto.svp.traveltogethermongo.dto.NewViajeDTO;
import com.sanalberto.svp.traveltogethermongo.services.ViajesServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.bson.json.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Path("/NuevoViaje")
public class NuevoViajeResource {

    private ViajesServices insertViajesServices = new ViajesServices();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @JwtTokenNeeded
    public String guardarNuevoViaje(@Context SecurityContext securityContext, String jsonInput){
        String output = "";
        String alias = securityContext.getUserPrincipal().getName();

        // Al tener que entrar en una propiedad interna de una clase nativa de Java, se reserializa para poder acceder con Gson a las propiedades internas de la clase (LocalDateTime).
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                    return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
                    return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));
                }
            })
            .create();

        NewViajeDTO newViajeDto = gson.fromJson(jsonInput, NewViajeDTO.class);
        output = insertViajesServices.createParseViaje(alias, newViajeDto);

        return output;
    }
}
