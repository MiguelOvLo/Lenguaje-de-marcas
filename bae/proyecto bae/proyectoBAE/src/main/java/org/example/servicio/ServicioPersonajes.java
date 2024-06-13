package org.example.servicio;


import java.util.List;
import org.example.modelo.Personajes;
import org.example.repositorio.RepositorioPersonajes;

public class ServicioPersonajes {
    private RepositorioPersonajes repositorioPersonajes;

    public ServicioPersonajes(RepositorioPersonajes repositorioPersonajes){
        this.repositorioPersonajes = repositorioPersonajes;
    }

    public void crearPersonaje(String nombre, String edad){
        Personajes personajes = new Personajes(nombre, edad);
        repositorioPersonajes.crearPersonaje(personajes);
    }

    public Personajes obtenerPersonajePorId(String id){
        return repositorioPersonajes.obtenerPersonajePorId(id);
    }

    public List<Personajes> obtenerTodosLosPersonajes(){
        return (List<Personajes>) repositorioPersonajes.obtenerTodosPersonajes();
    }

    public void actualizarPersonaje(String id, String nombre, String edad){
        Personajes personajeActualizado = new Personajes(nombre, edad);
        repositorioPersonajes.actualizarPersonaje(id, personajeActualizado);
    }
    
    public void eliminarPersonaje(String id){
        repositorioPersonajes.eliminarPersonaje(id);
    }

}
