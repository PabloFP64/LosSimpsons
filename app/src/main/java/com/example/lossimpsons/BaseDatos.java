package com.example.lossimpsons;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import org.w3c.dom.Document;

public class BaseDatos {

    private MongoClient mongoClient;
    private MongoDatabase db;

    public void conectar(){
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("baseDeDatos");
    }

    public void desconectar(){
        mongoClient.close();
    }

    public void anadirPersonaje(Personajes personaje){
        

    }

    public void modificarPersonaje(Personajes personaje){

    }

    public void eliminarPersonaje(Personajes personaje){

    }
}
