package es.ies.puerto.ejercicio44;

/**
 * 44. Clase Viaje con Itinerario
 * Crea una clase Viaje que tenga una lista (array) de destinos (clase Destinocon 
 * las propiedades: pais, ciudad, fecha ). Implementa métodos para agregar destinos 
 * al itinerario y usa toString() para describir el viaje.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Destino {
    private String pais;
    private String ciudad;
    private String fecha; 

    /**
     * Constructor por defecto
     */
    public Destino() {
    }

    /**
     * Constructor con todas las propiedades
     * @param pais
     * @param ciudad
     * @param fecha
     */
    public Destino(String pais, String ciudad, String fecha) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    /**
     * Getters and Setters
     */
    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "\nDestino{" +
                "pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}