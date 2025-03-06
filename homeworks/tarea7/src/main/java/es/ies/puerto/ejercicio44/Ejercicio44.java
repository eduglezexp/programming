package es.ies.puerto.ejercicio44;

/**
 * 44. Clase Viaje con Itinerario
 * Crea una clase Viaje que tenga una lista (array) de destinos (clase Destinocon 
 * las propiedades: pais, ciudad, fecha ). Implementa métodos para agregar destinos 
 * al itinerario y usa toString() para describir el viaje.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio44 {
    public static void main(String[] args) {
        Destino destino1 = new Destino("Francia", "París", "15/11/2024");
        Destino destino2 = new Destino("Italia", "Roma", "20/11/2024");
        Destino destino3 = new Destino("España", "Madrid", "25/11/2024");
        Viaje viaje = new Viaje("Tour por Europa");
        viaje.addDestino(destino1);
        viaje.addDestino(destino2);
        viaje.addDestino(destino3);
        System.out.println(viaje);
    }
}