package es.ies.puerto.ejercicio43;

/**
 * 43. Clase Galería con Pinturas
 * Crea una clase Galeria que almacene una lista (array) de pinturas (clase Pintura, 
 * con las propiedades: anio, artista, precio ). Implementa métodos para agregar, eliminar 
 * listar pinturas. Usa toString() para describir la galería.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio43 {
    public static void main(String[] args) {
        Galeria galeria = new Galeria("Galeria de Arte Moderno");
        Pintura pintura1 = new Pintura(2020, "Artista A", 1500f);
        Pintura pintura2 = new Pintura(2018, "Artista B", 2200f);
        Pintura pintura3 = new Pintura(2022, "Artista C", 3000f);
        galeria.addPintura(pintura1);
        galeria.addPintura(pintura2);
        galeria.addPintura(pintura3);
        System.out.println(galeria);
        galeria.deletePintura(pintura2);
        System.out.println("\nContenido de la galeria despues de eliminar una pintura:");
        System.out.println(galeria);
    }
}
