package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

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
        if (anio < 1 || mes == null) {
            return null;
        }
        LocalDate ultimoDiaDelMes = LocalDate.of(anio, mes, 
        mes.length(Year.isLeap(anio)));
        while (ultimoDiaDelMes.getDayOfWeek() != DayOfWeek.FRIDAY) {
            ultimoDiaDelMes = ultimoDiaDelMes.minusDays(1);
        }
        return ultimoDiaDelMes;
    }
}