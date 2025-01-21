package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Clase del ejercicio 5
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {

    /**
     * Funcion que dado un numero n, calcula cual sera el dia de la semana que ocurrira 
     * despues de sumar n dias a la fecha actua
     * @param fecha a sumar dias
     * @param dias dias a sumarle a la fecha
     * @return nueva fecha con los dias sumados
     */
    public static String obtenerDiaDeLaSemanaEnElFuturo(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        LocalDate nuevaFecha = fecha.plusDays(dias);
        return nuevaFecha.getDayOfWeek().toString();
    }

    public static void main(String[] args) {
        System.out.println(obtenerDiaDeLaSemanaEnElFuturo(LocalDate.now(), 100));
    }
}