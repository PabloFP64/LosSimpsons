package com.example.lossimpsons;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class BaseDatos {


    ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:1234@mydb.24vaewr.mongodb.net/?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = (MongoClient) MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("MyDB");


}
