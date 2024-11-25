package es.ies.puerto.ejercicio42;

/**
 * 42. Clase Cine con Proyecciones
 * Crea una clase Cine que almacene una lista (array) de proyecciones 
 * (clase Proyeccion, clase con propiedades: ciudad, hora, y fecha). 
 * Implementa métodos para agregar y eliminar proyecciones, y usa 
 * toString() para mostrar los detalles del cine.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio42 {
    public static void main(String[] args) {
        Cine cine = new Cine("Cine1");
        Proyeccion proyeccion1 = new Proyeccion("Ciudad A", "18:30", "2023-11-05");
        Proyeccion proyeccion2 = new Proyeccion("Ciudad B", "20:00", "2023-11-06");
        Proyeccion proyeccion3 = new Proyeccion("Ciudad C", "22:15", "2023-11-07");
        cine.addProyeccion(proyeccion1);
        cine.addProyeccion(proyeccion2);
        cine.addProyeccion(proyeccion3);
        System.out.println(cine);
        cine.deleteProyeccion(proyeccion2);
        System.out.println("\nContenido del cine despues de eliminar una proyeccion:");
        System.out.println(cine);
    }
}
