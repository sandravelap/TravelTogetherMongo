package com.sanalberto.svp.traveltogethermongo.repositories;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.dto.CercanosDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Destino;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CercanosRepo {
    private final MongoCollection<Destino> collection;

    public CercanosRepo() {
        MongoDatabase db = Connection.getDatabase();
        // Obtenemos la colección indicando la clase Destino.class
            this.collection =db.getCollection("Destino", Destino.class);
    }

    public List<Destino> getCercanos(CercanosDTO cercanosDTO) {
        List<Destino> destinos;
        /* Búsqueda que realizamos en MongoDB para devolver los documentos que se encuentran
        dentro de una distancia en metros de las coordenadas que le indicamos. */
        Document query = new Document("ubicacion", new Document("$near",
                new Document("$geometry", new Document("type", "Point")
                        .append("coordinates", Arrays.asList(cercanosDTO.getLongitude(), cercanosDTO.getLatitude())))
                        .append("$maxDistance", cercanosDTO.getRadio())
        ));
        // Guardamos el documento obtenido en una Lista de Destinos
        destinos = collection.find(query).into(new ArrayList<>());
        // Devolvemos los destinos encontrados
        return destinos;

    }
}
