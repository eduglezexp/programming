package es.ies.puerto;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

/**
 * Clase del ejercicio 9
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio9 {
    public static LocalDate obtenerPrimerLunesDelMes(int anio, int mes) {
        if (anio <= 0 || mes < 1 || mes > 12) {
            return null; 
        }
        LocalDate primerDiaMes = LocalDate.of(anio, mes, 1);
        while (primerDiaMes.getDayOfWeek() != DayOfWeek.MONDAY) {
            primerDiaMes = primerDiaMes.plusDays(1);
        }
        return primerDiaMes;
    }
}