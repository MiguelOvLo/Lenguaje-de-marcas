package org.example.controlador;

import com.mongodb.client.MongoDatabase;
import org.example.servicio.ServicioAnime;
import org.example.repositorio.RepositorioAnime;
import org.example.modelo.Anime;
import java.util.List;

public class ControladorAnime{

    private ServicioAnime servicioAnime;


    public ControladorAnime(MongoDatabase database){
        RepositorioAnime repositorioAnime = new RepositorioAnime(database);
        this.servicioAnime = new ServicioAnime(repositorioAnime);
    }

    public void crearAnime(String titulo, String genero){
        servicioAnime.crearAnime(titulo, genero);
    }

    public Anime obtenerAnimePorId(String id){
        return servicioAnime.obtenerAnimePorId(id);
    }

    public List<Anime> obtenerTodos(){
        return servicioAnime.obtenerTodos();
    }

    public void actualizarAnime(String id, String titulo, String genero){
        servicioAnime.actualizarAnime(id, titulo, genero);
    }

    public void eliminarAnime(String id){
        servicioAnime.eliminarAnime(id);
    }
}
