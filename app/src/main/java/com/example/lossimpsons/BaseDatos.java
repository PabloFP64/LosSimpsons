package com.example.lossimpsons;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class BaseDatos {



    ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:1234@mydb.24vaewr.mongodb.net/?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase db = mongoClient.getDatabase("LosSimpsons");


    public void desconectar(){
        mongoClient.close();
    }

    public boolean anadirUsuario(Usuario usuario){
        Document documento = new Document()
                .append("nombre", usuario.getNombre())
                .append("contrasena", usuario.getContrasena())
                .append("email", usuario.geteMail())
                .append("usuario", usuario.getUsuario());
        db.getCollection("usuarios").insertOne(documento);
        return true;
    }

    public void eliminarUsuario(String usuario){
        db.getCollection("usuarios").deleteOne(new Document("nombre", usuario));
    }

    public boolean comprobarUsuario(String usuario){
        FindIterable<Document> findIterable = db.getCollection("usuarios").find(new Document("usuario", usuario));
        if (findIterable.first().isEmpty()){
            return false;
        }else{
            return true;
        }

    }

    public boolean comprobarContrasena(String usuario, String contrasena){
        Document documento = new Document().append("usuario", usuario).append("contrasena", contrasena);
        if(db.getCollection("usuarios").find(documento).first().isEmpty()){
            return false;
        }else return true;
    }





}
