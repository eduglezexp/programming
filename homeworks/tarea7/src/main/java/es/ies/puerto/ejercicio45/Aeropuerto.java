package es.ies.puerto.ejercicio45;

/**
 * 45. Clase Aeropuerto con Vuelos
 * Crea una clase Aeropuerto que almacene una lista (array) de vuelos (clase Vuelo, con las 
 * propiedades: aerolinea, fecha, numero). Implementa métodos para agregar y eliminar vuelos, 
 * y usa toString() para mostrar los detalles del aeropuerto.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Aeropuerto {
    private int numeroVuelos;
    private String nombre;
    private Vuelo[] vuelos;

    /**
     * Constructor por defecto
     */
    public Aeropuerto() {
        this.numeroVuelos = 0;
        this.vuelos = new Vuelo[10]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Aeropuerto(String nombre) {
        this.nombre = nombre;
        this.numeroVuelos = 0;
        this.vuelos = new Vuelo[10]; 
    }

    /**
     * Metodo para agregar un vuelo al aeropuerto
     * @param vuelo
     * @return true/false
     */
    public boolean addVuelo(Vuelo vuelo) {
        if (vuelo == null) {
            return false;
        }
        if (numeroVuelos >= vuelos.length) {
            return false;
        }
        vuelos[numeroVuelos] = vuelo;
        numeroVuelos++;
        return true;
    }

    /**
     * Metodo para eliminar un vuelo del aeropuerto
     * @param vuelo
     * @return true/false
     */
    public boolean deleteVuelo(Vuelo vuelo) {
        if (vuelo == null) {
            return false;
        }
        if (numeroVuelos == 0) {
            return false;
        }
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelo.equals(vuelos[i])) {
                vuelos[i] = null;
                numeroVuelos--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para ordenar la lista de vuelos despues de una eliminación
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null) {
                vuelos[index++] = vuelos[i];
            }
        }
        while (index < vuelos.length) {
            vuelos[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Aeropuerto: " + nombre;
        for (int i = 0; i < numeroVuelos; i++) {
            mensaje += vuelos[i];
        }
        return mensaje;
    }
}