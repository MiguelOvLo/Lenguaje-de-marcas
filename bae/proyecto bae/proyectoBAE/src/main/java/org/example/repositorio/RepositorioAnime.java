package org.example.repositorio;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.modelo.Anime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class RepositorioAnime {
 
    private MongoCollection<Document> collection;

    public RepositorioAnime(MongoDatabase database) {

        this.collection = database.getCollection("Animu");
    }

    public void crearAnime (Anime anime){
        Document document = new Document("Título", anime.getTitulo())
            .append("Género", anime.getGenero());
        collection.insertOne(document);
        anime.setId(document.getObjectId("_id").toString());
    }

    public Anime obtenerAnimePorId(String id){

        Document document = collection.find(eq("_id", new ObjectId(id))).first();
        if (document !=null) {
            Anime anime = new Anime(document.getString("Título"), document.getString("Género"));
            anime.setId(document.getObjectId("_id").toString());
            return anime;
        }
        return null;
    }

    public List <Anime> obtenerTodos(){
        List<Anime> animes = new ArrayList<>();
        for(Document document : collection.find()){
            Anime anime = new Anime(document.getString("Título"), document.getString("Género"));
            anime.setId(document.getObjectId("_id").toString());
            animes.add(anime);
        }
        return animes;
    }

    public void actualizarAnime(String id, Anime animeActualizado){
        Document documentoActualizado = new Document("Título", animeActualizado.getTitulo())
            .append("Género", animeActualizado.getGenero());
        collection.updateOne(eq("_id", new ObjectId(id)), new Document("$set", documentoActualizado));
    }

    public void eliminarAnime(String id){
        collection.deleteOne(eq("_id", new ObjectId(id)));
    }
}
