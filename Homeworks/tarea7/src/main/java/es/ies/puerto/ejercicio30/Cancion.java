package es.ies.puerto.ejercicio30;

/**
 * 30. Clase Playlist con Canciones
 * Crea una clase Playlist que almacene una lista(array) de canciones (clase Cancion). 
 * Implementa métodos para agregar, eliminar y listar canciones. 
 * Usa toString() para mostrar la lista.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Cancion {
    private String titulo;
    private String artista;
    private int duracion;

    /**
     * Constructor por defecto
     */
    public Cancion() {

    } 

    /**
     * Constructor con todas las propiedades
     * @param titulo
     * @param artista
     * @param duracion
     */
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    /**
     * Getters and Setters
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "\nCancion [titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion + "]";
    }
}