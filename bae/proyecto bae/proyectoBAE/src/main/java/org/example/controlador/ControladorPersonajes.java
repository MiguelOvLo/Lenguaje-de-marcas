package org.example.controlador;

import org.example.repositorio.RepositorioPersonajes;
import org.example.servicio.ServicioPersonajes;

import java.util.List;

import org.example.modelo.Personajes;

import com.mongodb.client.MongoDatabase;

public class ControladorPersonajes {
    private ServicioPersonajes servicioPersonajes;

    public ControladorPersonajes(MongoDatabase database){
        RepositorioPersonajes repositorioPersonajes = new RepositorioPersonajes(database);
        this.servicioPersonajes = new ServicioPersonajes(repositorioPersonajes);
    }

    public void crearPersonaje(String nombre, String edad){
        servicioPersonajes.crearPersonaje(nombre, edad);
    }

    public Personajes obtenerPersonajePorId(String id){
        return servicioPersonajes.obtenerPersonajePorId(id);
    }

    public List<Personajes> obtenerTodos(){
        return servicioPersonajes.obtenerTodosLosPersonajes();
    }

    public void actualizarPersonaje(String id, String nombre, String edad){
        servicioPersonajes.actualizarPersonaje(id, nombre, edad);
    }

    public void eliminarPersonaje(String id){
        servicioPersonajes.eliminarPersonaje(id);
    }
}
