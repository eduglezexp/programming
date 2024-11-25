package es.ies.puerto.ejercicio46;

/**
 * 46. Clase Restaurante con Reservas
 * Crea una clase Restaurante que tenga una lista (array) de reservas (clase Reserva, 
 * con las propiedades: fecha, numero, comensales ). Implementa métodos para agregar 
 * y eliminar reservas y usa toString() para mostrar los detalles del restaurante.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio46 {
    public static void main(String[] args) {
        Reserva reserva1 = new Reserva("15/11/2024", 101, 4);
        Reserva reserva2 = new Reserva("16/11/2024", 102, 2);
        Reserva reserva3 = new Reserva("17/11/2024", 103, 6);
        Restaurante restaurante = new Restaurante("Restaurante1");
        restaurante.addReserva(reserva1);
        restaurante.addReserva(reserva2);
        restaurante.addReserva(reserva3);
        System.out.println(restaurante);
        restaurante.deleteReserva(reserva2);
        System.out.println("\nDespues de eliminar una reserva:");
        System.out.println(restaurante);
    }
}