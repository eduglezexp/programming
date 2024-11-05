package es.ies.puerto.ejercicio31;

import java.util.Objects;

/**
 * 31. Clase Película con Atributos y Métodos
 * Crea una clase Pelicula con atributos titulo, director, y duracion. 
 * Implementa métodos para comparar películas por duración con equals() 
 * y usar toString() para mostrar detalles.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Pelicula {
    private String titulo;
    private String director;
    private int duracion; 

    /**
     * Constructor por defecto
     */
    public Pelicula() {

    }

    /**
     * Constructor con todas las propiedades
     * @param titulo
     * @param director
     * @param duracion
     */
    public Pelicula(String titulo, String director, int duracion) {
        this.titulo = titulo;
        this.director = director;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pelicula)) {
            return false;
        }
        Pelicula pelicula = (Pelicula) o;
        return duracion == pelicula.duracion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(duracion);
    }
    
    @Override
    public String toString() {
        return "Título: " + titulo + ", Director: " + director + ", Duración: " + duracion + " minutos";
    }
}