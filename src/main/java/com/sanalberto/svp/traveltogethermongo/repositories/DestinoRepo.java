package com.sanalberto.svp.traveltogethermongo.repositories;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.dto.DestinoDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Destino;
import com.sanalberto.svp.traveltogethermongo.entities.Recomendacion;
import org.bson.conversions.Bson;

public class DestinoRepo {

    private final MongoCollection<Destino> collection;

    public DestinoRepo() {
        // "this.collection" se refiere al atributo de arriba
        this.collection = Connection.getDatabase()
                .getCollection("Destino", Destino.class);
    }
    public boolean updateDestino(DestinoDTO destinoDTO){
        boolean updated=false;
        Recomendacion recomendacion = null ;
        //Filtro para recuperar el Destino con el id)
        Bson filterDestinoByAlias = Filters.eq("alias_destino", destinoDTO.getAlias_destino());

        Bson update = Updates.set("descripcion", destinoDTO.getDescripcion());
        if (collection.updateOne(filterDestinoByAlias, update).wasAcknowledged()){
            updated = true;
        }

        return updated;
    }
}
