package es.ies.puerto.ejercicio26;

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
     * Constructor por defecto
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

    /**
     * Metodo para incluir un libro a la lista
     * @param libro
     * @return true/false
     */
    public boolean addLibro(Libro libro) {
        if (libro == null) {
            return false;
        }
        if (numeroLibros >= libros.length) {
            return false;
        }
        libros[numeroLibros] = libro;
        numeroLibros++;
        return true;
    }

    /**
     * Metodo para eliminar un libro de la lista
     * @param libro
     * @return true/false
     */
    public boolean deleteLibro(Libro libro) {
        if (libro == null) {
            return false;
        }
        if (numeroLibros == 0)  {
            return false;
        }
        for (int i = 0; i < libros.length; i++) {
            if (libro.equals(libros[i])) {
                libros[i] = null;
                numeroLibros--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista despues de eliminar un libro
     */
    public void ordenarLista() {
        int index = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                libros[index++] = libros[i];
            }
        }
        while (index < libros.length) {
            libros[index++] = null;
        }
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