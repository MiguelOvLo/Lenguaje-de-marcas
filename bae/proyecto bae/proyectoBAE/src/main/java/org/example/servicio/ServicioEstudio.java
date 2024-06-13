package org.example.servicio;

import java.util.List;

import org.example.modelo.Estudio;
import org.example.repositorio.RepositorioEstudio;

public class ServicioEstudio {
    private RepositorioEstudio repositorioEstudio;

    public ServicioEstudio(RepositorioEstudio repositorioEstudio){
        this.repositorioEstudio = repositorioEstudio;
    }

    public void crearEstudio(String nombre, String ubicacion){
        Estudio estudio = new Estudio(nombre, ubicacion);
        repositorioEstudio.crearEstudio(estudio);
    }

    public Estudio obtenerEstudioPorId(String id){
        return repositorioEstudio.obtenerEstudioPorId(id);
    }

    public List<Estudio> obtenerTodosLosEstudios(){
        return repositorioEstudio.obtenerTodosEstudios();
    }

    public void actualizarEstudio(String id, String nombre, String ubicacion){
        Estudio estudioActualizado = new Estudio(nombre, ubicacion);
        repositorioEstudio.actualizarEstudio(id, estudioActualizado);
    }

    public void eliminarEstudio(String id){
        repositorioEstudio.eliminarEstudio(id);
    }
    
}
