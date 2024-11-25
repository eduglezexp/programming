package es.ies.puerto.ejercicio29;

import es.ies.puerto.ejercicio17.Libro;

/**
 * 29. Clase Estantería con Libros
 * Crea una clase Estanteria con una lista (array) (array) de libros. 
 * Implementa métodos para agregar libros y ordenarlos por título. 
 * Usa toString() para mostrar los detalles de la estantería.
 * @author edglezexp 
 * @version 1.0.0
 */

public class Estanteria {
    private int numeroLibros;
    private String nombre;
    private Libro[] libros;

    /**
     * Constructor por defecto
     */
    public Estanteria() {
        numeroLibros = 0;
        libros = new Libro[5];
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Estanteria(String nombre) {
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
     * Metodo para ordenar los libros por titulo
     */
    public void ordenarLibrosPorTitulo() {
        for (int i = 0; i < numeroLibros - 1; i++) {
            for (int j = 0; j < numeroLibros - i - 1; j++) {
                if (libros[j].getTitulo().compareToIgnoreCase(libros[j + 1].getTitulo()) > 0) {
                    Libro temporal = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temporal;
                }
            }
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