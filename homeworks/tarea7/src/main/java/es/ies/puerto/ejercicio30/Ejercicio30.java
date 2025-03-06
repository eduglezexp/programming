package es.ies.puerto.ejercicio30;

/**
 * 30. Clase Playlist con Canciones
 * Crea una clase Playlist que almacene una lista(array) de canciones (clase Cancion). 
 * Implementa métodos para agregar, eliminar y listar canciones. 
 * Usa toString() para mostrar la lista.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio30 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Mis Canciones Favoritas");
        Cancion cancion1 = new Cancion("Bohemian Rhapsody", "Queen", 3);
        Cancion cancion2 = new Cancion("Imagine", "John Lennon", 2);
        Cancion cancion3 = new Cancion("Hotel California", "Eagles", 3);
        playlist.addCancion(cancion1);
        playlist.addCancion(cancion2);
        playlist.addCancion(cancion3);
        System.out.println("Antes de eliminar:");
        System.out.println(playlist);
        playlist.deleteCancion(cancion2);
        System.out.println("Despues de eliminar:");
        System.out.println(playlist);
    }
}
