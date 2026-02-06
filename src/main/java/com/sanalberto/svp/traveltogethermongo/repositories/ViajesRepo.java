package com.sanalberto.svp.traveltogethermongo.repositories;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.entities.Viaje;

import java.util.ArrayList;
import java.util.List;


public class ViajesRepo {
    private final MongoCollection<Viaje> collection; // <--- Atributo de la clase

    public ViajesRepo() {
        // "this.collection" se refiere al atributo de arriba
        this.collection = Connection.getDatabase()
                .getCollection("Viaje", Viaje.class);
    }

    public List<Viaje> getViajes(){
        // Recupera todos los documentos de la colección y los convierte a objetos Viaje
        return collection.find().into(new ArrayList<>());

    }

    public void registrarViajeCompleto(Viaje nuevoViaje) {
        collection.insertOne(nuevoViaje);
    }

    // Consulta RA5: Buscar viajes que tengan una etapa en un destino específico
    public List<Viaje> buscarViajesPorDestino(int idDestinoBuscado) {
        return collection.find(Filters.eq("etapas.idDestino", idDestinoBuscado))
                .into(new ArrayList<>());
    }

    public List<Viaje> buscarViajesPorFiltro() {
        // Ejemplo de consulta: Viajes donde el nombre contiene "Picos"
        return collection.find(Filters.regex("nombre","Picos"))
                .into(new ArrayList<>());

    }
}

