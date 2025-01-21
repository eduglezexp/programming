package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Clase del ejercicio 6
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {

    /**
     * Funcion que calcula la cantidad de fines de semana (sabado y domingo) 
     * que ocurren en un mes
     * @param anio de la fecha
     * @param mes de la fecha
     * @return cantidad de dias de dines de semana
     */
    public static int obtenerFinesDeSemana(int anio, Month mes) {
        if (anio < 1 || mes == null) {
            return -1; 
        }
        LocalDate inicioMes = LocalDate.of(anio, mes, 1);
        LocalDate finMes = inicioMes.withDayOfMonth(inicioMes.lengthOfMonth());
        int cantidadFinesDeSemana = 0;
        for (LocalDate fecha = inicioMes; !fecha.isAfter(finMes); fecha = 
        fecha.plusDays(1)) {
            if (fecha.getDayOfWeek() == DayOfWeek.SATURDAY || 
            fecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
                cantidadFinesDeSemana++;
            }
        }
        return cantidadFinesDeSemana;
    }
}