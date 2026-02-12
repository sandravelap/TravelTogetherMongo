package com.sanalberto.svp.traveltogethermongo.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Connection {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Se usan las variables de entorno de tu docker-compose.
    private static final String HOST = System.getenv().getOrDefault("MONGO_HOST", "localhost");
    private static final String PORT = System.getenv().getOrDefault("MONGO_PORT", "27018");
    private static final String DB_NAME = System.getenv().getOrDefault("MONGO_DATABASE", "traveltogether");
    private static final String USER = System.getenv().getOrDefault("MONGO_USER", "root");
    private static final String PASS = System.getenv().getOrDefault("MONGO_PASSWORD", "admin");

    public static MongoDatabase getDatabase() {
        // 1. Se configura el PojoCodecProvider para que registre todas las clases automáticamente.
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );

        if (mongoClient == null) {
            String connectionString = String.format("mongodb://%s:%s@%s:%s", USER, PASS, HOST, PORT);
            mongoClient = MongoClients.create(connectionString);

            // 2. Se aplica el registro a la base de datos.
            database = mongoClient.getDatabase(DB_NAME).withCodecRegistry(pojoCodecRegistry);
        }
        return database;
    }
}

