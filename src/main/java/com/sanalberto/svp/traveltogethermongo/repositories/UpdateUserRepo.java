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
    public boolean update(UpdateUserDTO updateUserDTO) {
        boolean updated = false;
        // Filtramos por el alias del usuario.
        Bson filterUserByAlias = Filters.eq("alias", updateUserDTO.getAlias());
        // Si existe un usuario con ese alias seteamos sus campos con los del DTO.
        if (collection.find(filterUserByAlias).first() != null) {
            Bson update = Updates.combine(
                    Updates.set("nombre", updateUserDTO.getNombre()),
                    Updates.set("correo", updateUserDTO.getCorreo()),
                    Updates.set("tabaco", updateUserDTO.getTabaco()),
                    Updates.set("mascota", updateUserDTO.getMascota()));
            // Si se ha podido actualizar devolvemos true.
            if (collection.updateOne(filterViajeByName, update).wasAcknowledged()) {
                updated = true;
            }
        }
        
        return updated;
    }
}