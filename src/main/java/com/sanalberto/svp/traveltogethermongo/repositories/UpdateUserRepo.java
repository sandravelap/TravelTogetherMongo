package com.sanalberto.svp.traveltogethermongo.repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.dto.UpdateUserDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Usuario;

public class UpdateUserRepo {
    private final MongoCollection<Usuario> collection;
    public UpdateUserRepo() {
        // "this.collection" se refiere al atributo de arriba
        this.collection = Connection.getDatabase()
                .getCollection("Usuario", Usuario.class);

    }
    public String update(UpdateUserDTO updateUserDTO, String alias) {
        String respuesta = "";
        try {
            // Método para modificar varios campos en el update
            collection.updateOne(Filters.eq("alias", alias), Updates.combine(
                    Updates.set("nombre", updateUserDTO.getNombre()),
                    Updates.set("correo", updateUserDTO.getCorreo()),
                    Updates.set("tabaco", updateUserDTO.getTabaco()),
                    Updates.set("mascota", updateUserDTO.getMascota())));


            respuesta = "Usuario modificado exitosamente";
        } catch (Exception e) {
            respuesta = "Error al modificar usuario";
        }
        return respuesta;
    }
}