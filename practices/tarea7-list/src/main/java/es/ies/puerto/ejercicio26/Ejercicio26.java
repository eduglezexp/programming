package es.ies.puerto.ejercicio26;

import es.ies.puerto.ejercicio17.Libro;

public class Ejercicio26 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El principito", 
        "Antoine de Saint-Exupéry", 417);
        Libro libro2 = new Libro("Cien años de soledad", 
        "Gabriel García Márquez", 310);
        Biblioteca biblioteca = new Biblioteca("TheLibrary");
        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);
        System.out.println(biblioteca);
        biblioteca.deleteLibro(libro1);
        System.out.println(biblioteca);
    }
}
