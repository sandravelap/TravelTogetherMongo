package com.sanalberto.svp.traveltogethermongo.repositories;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.dto.NewEtapaDTO;
import com.sanalberto.svp.traveltogethermongo.entities.Etapa;
import com.sanalberto.svp.traveltogethermongo.entities.Viaje;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;


public class ViajesRepo {
    // Aributo de la clase.
    private final MongoCollection<Viaje> collection;

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

    public String updateEtapasViaje(String aliasCreador, String inputNombre, List<Etapa> etapasArrayList){
        String output = "";

        Bson nameViaje = eq("nombre", inputNombre);

        ArrayList<Viaje> aliasCreadorExistsArrayList = collection.find(Filters.regex("aliasCreador", aliasCreador)).into(new ArrayList<>());

        if(!aliasCreadorExistsArrayList.isEmpty()){

            if(collection.updateOne(nameViaje, set("etapas", etapasArrayList)).wasAcknowledged()){
                output = "MONGO >> etapa del viaje con nombre " + inputNombre + " actualizada correctamente.";
            }
            else{
                output = "MONGO >> Ha habido un error al actualizar la tabla.";
            }
        }

        return output;
    }
}

