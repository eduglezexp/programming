package es.ies.puerto.ejercicio16;

/**
 * 16. Clase Fecha con Métodos de Validación
 * Crea una clase Fecha con atributos dia, mes y anio. Implementa métodos para validar 
 * si la fecha es correcta y para comparar dos fechas con equals().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio16 {
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha(29, 2, 2024); 
        Fecha fecha2 = new Fecha(29, 2, 2023); 
        Fecha fecha3 = new Fecha(29, 2, 2024); 
        System.out.println(fecha1 + " es valida? " + fecha1.esFechaValida());
        System.out.println(fecha2 + " es valida? " + fecha2.esFechaValida());
        System.out.println("¿fecha1 es igual a fecha3? " + fecha1.equals(fecha3));
    }
}