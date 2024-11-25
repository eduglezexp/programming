package es.ies.puerto.ejercicio44;

/**
 * 44. Clase Viaje con Itinerario
 * Crea una clase Viaje que tenga una lista (array) de destinos (clase Destinocon 
 * las propiedades: pais, ciudad, fecha ). Implementa métodos para agregar destinos 
 * al itinerario y usa toString() para describir el viaje.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Viaje {
    private int numeroDestinos;  
    private String nombre;
    private Destino[] itinerario; 

    /**
     * Constructor por defecto
     */
    public Viaje() {
        this.numeroDestinos = 0;  
        this.itinerario = new Destino[10];
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Viaje(String nombre) {
        this.nombre = nombre;
        this.numeroDestinos = 0;  
        this.itinerario = new Destino[10];
    }

    /**
     * Metodo para agregar un destino al viaje
     * @param destino
     * @return true/false
     */
    public boolean addDestino(Destino destino) {
        if (destino == null) {
            return false;
        }
        if (numeroDestinos >= itinerario.length) {
            return false;
        }
        itinerario[numeroDestinos] = destino;
        numeroDestinos++;
        return true;
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " +nombre;
        for (int i = 0; i < numeroDestinos; i++) {
            mensaje += itinerario[i];
        }
        return mensaje;
    }
}