package es.ies.puerto.ejercicio46;

/**
 * 46. Clase Restaurante con Reservas
 * Crea una clase Restaurante que tenga una lista (array) de reservas (clase Reserva, 
 * con las propiedades: fecha, numero, comensales ). Implementa métodos para agregar 
 * y eliminar reservas y usa toString() para mostrar los detalles del restaurante.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Reserva {
    private String fecha;  
    private int numero;    
    private int comensales; 

    /**
     * Constructor por defecto
     */
    public Reserva() {
    }
    
    /**
     * Constructor con todas las propiedades
     * @param fecha
     * @param numero
     * @param comensales
     */
    public Reserva(String fecha, int numero, int comensales) {
        this.fecha = fecha;
        this.numero = numero;
        this.comensales = comensales;
    }

    /**
     * Getters and Setters
     */
    public String getFecha() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }

    public int getComensales() {
        return comensales;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    @Override
    public String toString() {
        return "\nReserva{" +
                "fecha='" + fecha + '\'' +
                ", numero=" + numero +
                ", comensales=" + comensales +
                '}';
    }
}