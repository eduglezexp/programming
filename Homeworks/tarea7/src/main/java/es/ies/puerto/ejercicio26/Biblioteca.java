package es.ies.puerto.ejercicio26;

import java.util.Arrays;

import es.ies.puerto.ejercicio17.Libro;

/**
 * 26. Clase Biblioteca con Libros
 * Crea una clase Biblioteca que almacene una lista (array) (array) de libros 
 * (clase Libro). Implementa métodos para agregar libros, eliminar libros y listar 
 * todos los libros. Usa toString() para describir la biblioteca.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Biblioteca {
    private int numeroLibros;
    private String nombre;
    private Libro[] libros;

    /**
     * Constructor con todas las propiedades
     */
    public Biblioteca() {
        numeroLibros = 0;
        libros = new Libro[5];
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        numeroLibros = 0;
        libros = new Libro[5];
    }

    /**
     * Getters and Setters
     */
    public int getNumeroLibros() {
        return numeroLibros;
    }

    public void setNumeroLibros(int numeroLibros) {
        this.numeroLibros = numeroLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroLibros; i++) {
            mensaje += libros[i];
        }
        return mensaje;
    }
}