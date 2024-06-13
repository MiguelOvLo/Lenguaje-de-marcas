package org.example;

import java.util.List;
import org.example.controlador.ControladorAnime;
import org.example.controlador.ControladorEstudio;
import org.example.controlador.ControladorPersonajes;
import org.example.modelo.Anime;
import org.example.modelo.Personajes;
import org.example.modelo.Estudio;
import com.mongodb.client.*;
import com.mongodb.client.MongoDatabase;

public class Main{
    public static void main( String[] args ) {

        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://movalle49:6YShx2fKabry3d0t@miguel.wlr5fok.mongodb.net/?retryWrites=true&w=majority&appName=Miguel";

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://movalle49:6YShx2fKabry3d0t@miguel.wlr5fok.mongodb.net/?retryWrites=true&w=majority&appName=Miguel")) {
            MongoDatabase database = mongoClient.getDatabase("ProyectoBae");

            ControladorAnime controladorAnime = new ControladorAnime(database);
            ControladorPersonajes controladorPersonajes = new ControladorPersonajes(database);
            ControladorEstudio controladorEstudio = new ControladorEstudio(database); 

            /*crearAnime(controladorAnime);*/
            /*leerAnimes(controladorAnime);*/
            actualizarAnime(controladorAnime);
            /*eliminarAnime(controladorAnime);*/

           /*crearPersonaje(controladorPersonajes);*/
            /*leerPersonajes(controladorPersonajes);*/
            /*actualizarPersonaje(controladorPersonajes);*/
            /*eliminarPersonaje(controladorPersonajes);*/

            /*crearEstudio(controladorEstudio);*/
            /*leerEstudios(controladorEstudio);*/
            /*actualizarEstudio(controladorEstudio);*/
            /*eliminarEstudio(controladorEstudio);*/
            
           
        }
    }

    public static void crearAnime(ControladorAnime controladorAnime){
        controladorAnime.crearAnime("Steins;Gate", "Ciencia Ficcion");
        System.out.println("Anime creado.");
    }

    public static void leerAnimes(ControladorAnime controladorAnime){
        List<Anime> animes = controladorAnime.obtenerTodos();
        for(Anime anime : animes){
            System.out.println("Anime: "+ anime.getTitulo()+ ", Género: "+anime.getGenero()+".");
        }
    }

    public static void actualizarAnime(ControladorAnime controladorAnime){
        List<Anime> animes = controladorAnime.obtenerTodos();
        if (!animes.isEmpty()) {
            Anime anime = animes.get(0);
            controladorAnime.actualizarAnime(anime.getId(), "Naruto Shippuden", "Shonen");
            System.out.println("Anime actualizado");
        }
    }

    public static void eliminarAnime(ControladorAnime controladorAnime){
        List<Anime> animes = controladorAnime.obtenerTodos();
        if (!animes.isEmpty()) {
            Anime anime = animes.get(0);
            controladorAnime.eliminarAnime(anime.getId());
            System.out.println("Anime "+anime.getTitulo()+" eliminado.");
        }
    }


    public static void crearPersonaje(ControladorPersonajes controladorPersonajes){
        controladorPersonajes.crearPersonaje("Naruto Uzumaki", "17");
    }

    public static void leerPersonajes(ControladorPersonajes controladorPersonajes){
        List<Personajes> personajes = controladorPersonajes.obtenerTodos();
        for(Personajes personaje : personajes){
            System.out.println("Nombre: "+ personaje.getNombre()+ ", Edad: "+personaje.getedad()+".");
        }  
    }


    public static void actualizarPersonaje(ControladorPersonajes controladorPersonajes){
        List<Personajes> personajes = controladorPersonajes.obtenerTodos();
        if (!personajes.isEmpty()) {
            Personajes personaje = personajes.get(3);
            controladorPersonajes.actualizarPersonaje(personaje.getId(), "Naruto Uzumaki", "20");
            System.out.println("Anime actualizado a "+personaje.getNombre());
        }
    }


    public static void eliminarPersonaje(ControladorPersonajes controladorPersonajes){
        List<Personajes> personajes = controladorPersonajes.obtenerTodos();
        if (!personajes.isEmpty()) {
            Personajes personaje = personajes.get(0);
            controladorPersonajes.eliminarPersonaje(personaje.getId());
            System.out.println("Nombre "+personaje.getNombre()+" eliminado.");
        }
    }

    public static void crearEstudio(ControladorEstudio controladorEstudio){
        controladorEstudio.crearEstudio("Mappa", "Tokyo");
    }

    public static void leerEstudios(ControladorEstudio controladorEstudio){
        List<Estudio> estudios = controladorEstudio.obtenerTodo();
        for(Estudio estudio : estudios){
            System.out.println("Nombre: "+ estudio.getNombre()+ ", Ubicación: "+estudio.getUbicacion()+".");
        } 
    }

    public static void actualizarEstudio(ControladorEstudio controladorEstudio){
        List<Estudio> estudios = controladorEstudio.obtenerTodo();
        if (!estudios.isEmpty()) {
            Estudio estudio = estudios.get(0);
            controladorEstudio.actualizarEstudio(estudio.getId(), "mappa", "Tokyo");
            System.out.println("Estudio actualizado a "+estudio.getNombre());
        }
    }

    public static void eliminarEstudio(ControladorEstudio controladorEstudio){
        List<Estudio> estudios = controladorEstudio.obtenerTodo();
        if (!estudios.isEmpty()) {
            Estudio estudio = estudios.get(0);
            controladorEstudio.eliminarEstudio(estudio.getId());
            System.out.println("Nombre"+estudio.getNombre()+"eliminado.");
            
        }
    }
}