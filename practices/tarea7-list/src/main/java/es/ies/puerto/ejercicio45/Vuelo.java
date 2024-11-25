package es.ies.puerto.ejercicio45;

/**
 * 45. Clase Aeropuerto con Vuelos
 * Crea una clase Aeropuerto que almacene una lista (array) de vuelos (clase Vuelo, con las 
 * propiedades: aerolinea, fecha, numero). Implementa métodos para agregar y eliminar vuelos, 
 * y usa toString() para mostrar los detalles del aeropuerto.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Vuelo {
    private String aerolinea;
    private String fecha;  
    private int numero;

    /**
     * Constructor por defecto
     */
    public Vuelo() {
    }

    /**
     * Constructor con todas las propiedades
     */
    public Vuelo(String aerolinea, String fecha, int numero) {
        this.aerolinea = aerolinea;
        this.fecha = fecha;
        this.numero = numero;
    }

    /**
     * Getters and Setters
     */
    public String getAerolinea() {
        return aerolinea;
    }

    public String getFecha() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\nVuelo{" +
                "aerolinea='" + aerolinea + '\'' +
                ", fecha='" + fecha + '\'' +
                ", numero=" + numero +
                '}';
    }
}