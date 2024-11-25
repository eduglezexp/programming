package es.ies.puerto.ejercicio46;

/**
 * 46. Clase Restaurante con Reservas
 * Crea una clase Restaurante que tenga una lista (array) de reservas (clase Reserva, 
 * con las propiedades: fecha, numero, comensales ). Implementa métodos para agregar 
 * y eliminar reservas y usa toString() para mostrar los detalles del restaurante.
 * @author eduglezexp
 * @version 1.0.0
 */

 public class Restaurante {
    private int numeroReservas; 
    private String nombre;    
    private Reserva[] reservas; 

    /**
     * Constructor por defecto
     */
    public Restaurante() {
        this.numeroReservas = 0;
        this.reservas = new Reserva[10]; 
    }

    /**
     * Constructor con la propiedad nombre
     * @param nombre
     */
    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.numeroReservas = 0;
        this.reservas = new Reserva[10];
    }

    /**
     * Metodo para agregar una reserva al restaurante
     * @param reserva
     * @return true/false
     */
    public boolean addReserva(Reserva reserva) {
        if (reserva == null) {
            return false;
        }
        if (numeroReservas >= reservas.length) {
            return false; 
        }
        reservas[numeroReservas] = reserva;
        numeroReservas++;
        return true;
    }

    /**
     * Metodo para eliminar una reserva del restaurante
     * @param reserva
     * @return true/false
     */
    public boolean deleteReserva(Reserva reserva) {
        if (reserva == null) {
            return false;
        }
        if (numeroReservas == 0) {
            return false; 
        }
        for (int i = 0; i < reservas.length; i++) {
            if (reserva.equals(reservas[i])) {
                reservas[i] = null;
                numeroReservas--;
                ordenarLista();
                return true;
            }
        }
        return false; 
    }

    /**
     * Método para ordenar la lista de reservas despues de una eliminacion
     */
    private void ordenarLista() {
        int index = 0;
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] != null) {
                reservas[index++] = reservas[i];
            }
        }
        while (index < reservas.length) {
            reservas[index++] = null;
        }
    }

    @Override
    public String toString() {
        String mensaje = "Nombre: " + nombre;
        for (int i = 0; i < numeroReservas; i++) {
            mensaje += reservas[i];
        }
        return mensaje;
    }
}