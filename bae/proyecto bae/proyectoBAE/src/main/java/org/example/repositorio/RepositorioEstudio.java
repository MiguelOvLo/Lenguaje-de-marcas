package org.example.repositorio;


import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.modelo.Estudio;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;



public class RepositorioEstudio {
    private MongoCollection<Document> collection;

    public RepositorioEstudio(MongoDatabase database){
        this.collection = database.getCollection("Estudios");
    }

    public void crearEstudio(Estudio estudio){
        Document document = new Document("Nombre", estudio.getNombre())
        .append("Ubicación", estudio.getUbicacion());
        collection.insertOne(document);
        estudio.setId(document.getObjectId("_id").toString());
        }
    
        public Estudio obtenerEstudioPorId(String id){
            Document document = collection.find(eq("_id", new ObjectId(id))).first();
            if(document != null){
                Estudio estudios = new Estudio(document.getString("Nombre"), document.getString("Ubicación"));
                estudios.setId(document.getObjectId("_id").toString());
                return estudios;
            }
            return null;
        }

        public List <Estudio> obtenerTodosEstudios(){
            List<Estudio> estudios = new ArrayList<>();

            for(Document document : collection.find()){
                Estudio estudio = new Estudio(document.getString("Nombre"), document.getString("Ubicación"));
                estudio.setId(document.getObjectId("_id").toString());
                estudios.add(estudio);
            }
            return estudios;
        }
    
        public void actualizarEstudio(String id, Estudio estudioActualizado){
            Document actualizarEstudio = new Document("Nombre", estudioActualizado.getNombre())
                .append("Ubicación", estudioActualizado.getUbicacion());
            collection.updateOne(eq("_id", new ObjectId(id)), new Document("$set", actualizarEstudio));
        }
    
        public void eliminarEstudio(String id){
            collection.deleteOne(eq("_id", new ObjectId(id)));
        }  
}
