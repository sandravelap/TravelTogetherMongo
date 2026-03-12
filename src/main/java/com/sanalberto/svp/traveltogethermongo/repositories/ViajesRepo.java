package com.sanalberto.svp.traveltogethermongo.repositories;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.entities.Etapa;
import com.sanalberto.svp.traveltogethermongo.entities.Viaje;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


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
        return collection.find(eq("etapas.idDestino", idDestinoBuscado))
                .into(new ArrayList<>());
    }

    public List<Viaje> buscarViajesPorFiltro() {
        // Ejemplo de consulta: Viajes donde el nombre contiene "Picos"
        return collection.find(Filters.regex("nombre","Picos"))
                .into(new ArrayList<>());

    }

    public String insertNewViaje(Viaje viajeDao){
        String output = "";

        // Hace el insert del viaje y devuelve una respuesta dependiendo del resultado de la inserción.
        if(collection.insertOne(viajeDao).wasAcknowledged()){
            output = "MONGO >> Viaje registrado exitosamente.";
        }
        else{
            output = "MONGO >> No se ha podido registrar el viaje.";
        }

        return output;
    }

    public String updateEtapasViaje(String aliasCreador, String inputViaje, List<Etapa> etapasArrayList){
        String output = "";

        // todo: cambiar a nombreViaje (String)
        // done!
        Bson nameViaje = eq("nombreViaje", inputViaje);

        ArrayList<Viaje> aliasCreadorExistsArrayList = collection.find(Filters.regex("aliasCreador", aliasCreador)).into(new ArrayList<>());

        // todo: comprobar que aliasCreador existe antes de ejecutar el update (recuperar el alias con una sentencia y un 'where').
        // done lol!
        if(!aliasCreadorExistsArrayList.isEmpty()){
            if(collection.updateOne(nameViaje, (Bson) etapasArrayList).wasAcknowledged()){
                output = "MONGO >> etapa con ID " + inputViaje + " actualizada correctamente.";
            }
            else{
                output = "MONGO >> Ha habido un error al actualizar la tabla.";
            }
        }

        return output;
    }
}

