package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Clase del ejercicio 3
 * @author eduglezexp
 * @version 1.0.0
 */
public class Ejercicio3 {

    /**
     * Funcion para obtener el ultimo viernes de un mes
     * @param anio de la fecha
     * @param mes de la fecha
     * @return la fecha del ultimo viernes
     */
    public static LocalDate obtenerUltimoViernes(int anio, Month mes) {
        LocalDate localDate = LocalDate.of(anio, mes, 0);
        boolean viernes = localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY);
        return localDate;
    }
}
