package com.sanalberto.svp.traveltogethermongo.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sanalberto.svp.traveltogethermongo.database.Connection;
import com.sanalberto.svp.traveltogethermongo.entities.Usuario;

public class UsuarioDAO {

    private final MongoCollection<Usuario> collection;

    public UsuarioDAO() {
        MongoDatabase db = Connection.getDatabase();
        // Obtenemos la colección indicando la clase Usuario.class
        this.collection = db.getCollection("Usuario", Usuario.class);
    }

    //Create
    public void insertarUsuario(Usuario user) {
        collection.insertOne(user);
    }

    //Read
    public Usuario buscarPorAlias(String alias) {
        // Ya no devuelve un Document, sino un objeto Usuario directamente
        return collection.find(Filters.eq("alias", alias)).first();
    }
}

