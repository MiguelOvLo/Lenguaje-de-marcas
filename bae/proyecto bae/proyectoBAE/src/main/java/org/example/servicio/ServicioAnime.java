package org.example.servicio;

import java.util.List;
import org.example.modelo.Anime;
import org.example.repositorio.RepositorioAnime;

public class ServicioAnime {
    private RepositorioAnime repositorioAnime;

    public ServicioAnime(RepositorioAnime repositorioAnime){
        this.repositorioAnime = repositorioAnime;
    }

    public void crearAnime(String titulo, String genero){
        Anime anime = new Anime(titulo, genero);
        repositorioAnime.crearAnime(anime);
    }

    public Anime obtenerAnimePorId(String id){
        return repositorioAnime.obtenerAnimePorId(id);
    }

    public List<Anime> obtenerTodos(){
        return (List<Anime>) repositorioAnime.obtenerTodos();
    }

    public void actualizarAnime(String id, String titulo, String genero){
        Anime animeActualizado = new Anime(titulo, genero);
        repositorioAnime.actualizarAnime(id, animeActualizado);
    }
    
    public void eliminarAnime(String id){
        repositorioAnime.eliminarAnime(id);
    }

}
