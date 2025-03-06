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

public class Ejercicio29 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Principito");
        Libro libro2 = new Libro("Cien Años de Soledad");
        Libro libro3 = new Libro("Don Quijote de la Mancha");
        Estanteria estanteria = new Estanteria("Estanteria1");
        estanteria.addLibro(libro1);
        estanteria.addLibro(libro2);
        estanteria.addLibro(libro3);
        System.out.println("Antes de ordenar:");
        System.out.println(estanteria);
        estanteria.ordenarLibrosPorTitulo();
        System.out.println("Despues de ordenar:");
        System.out.println(estanteria);
    }
}