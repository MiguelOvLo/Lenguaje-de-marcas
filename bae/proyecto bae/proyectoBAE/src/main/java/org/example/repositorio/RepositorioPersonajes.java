package org.example.repositorio;


import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.modelo.Personajes;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;



public class RepositorioPersonajes {
    private MongoCollection<Document> collection;

    public RepositorioPersonajes(MongoDatabase database){
        this.collection = database.getCollection("Protas");
    }

    public void crearPersonaje(Personajes personajes){
        Document document = new Document("nombre", personajes.getNombre())
        .append("edad", personajes.getedad());
        collection.insertOne(document);
        personajes.setId(document.getObjectId("_id").toString());
        }
    
        public Personajes obtenerPersonajePorId(String id){
            Document document = collection.find(eq("_id", new ObjectId(id))).first();
            if(document != null){
                Personajes personajes = new Personajes(document.getString("nombre"), document.getString("edad"));
                personajes.setId(document.getObjectId("_id").toString());
                return personajes;
            }
            return null;
        }

        public List <Personajes> obtenerTodosPersonajes(){
            List<Personajes> personajes = new ArrayList<>();

            for(Document document : collection.find()){
                Personajes personaje = new Personajes(document.getString("Nombre"), document.getString("edad"));
                personaje.setId(document.getObjectId("_id").toString());
                personajes.add(personaje);
            }
            return personajes;
        }
    
        public void actualizarPersonaje(String id, Personajes personajeActualizado){
            Document documentoActualizado = new Document("Nombre", personajeActualizado.getNombre())
                .append("edad", personajeActualizado.getedad());
            collection.updateOne(eq("_id", new ObjectId(id)), new Document("$set", documentoActualizado));
        }
    
        public void eliminarPersonaje(String id){
            collection.deleteOne(eq("_id", new ObjectId(id)));
        }
}
