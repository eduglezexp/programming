package es.ies.puerto.ejercicio45;

/**
 * 45. Clase Aeropuerto con Vuelos
 * Crea una clase Aeropuerto que almacene una lista (array) de vuelos (clase Vuelo, con las 
 * propiedades: aerolinea, fecha, numero). Implementa métodos para agregar y eliminar vuelos, 
 * y usa toString() para mostrar los detalles del aeropuerto.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio45 {
    public static void main(String[] args) {
        Vuelo vuelo1 = new Vuelo("aerolinea1", "15/11/2024", 101);
        Vuelo vuelo2 = new Vuelo("aerolinea2", "16/11/2024", 102);
        Vuelo vuelo3 = new Vuelo("aerolinea3", "17/11/2024", 103);
        Aeropuerto aeropuerto = new Aeropuerto("Aeropuerto Internacional");
        aeropuerto.addVuelo(vuelo1);
        aeropuerto.addVuelo(vuelo2);
        aeropuerto.addVuelo(vuelo3);
        System.out.println(aeropuerto);
        aeropuerto.deleteVuelo(vuelo2);
        System.out.println("\nDespues de eliminar un vuelo:");
        System.out.println(aeropuerto);
    }
}
