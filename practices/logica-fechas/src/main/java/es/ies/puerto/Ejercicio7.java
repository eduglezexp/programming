package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;


/**
 * Clase del ejercicio 7
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio7 {
    
    /**
     * Funcion que calcula la fecha exacta para el Dia de la Madre 
     * (en el pais correspondiente) en cualquier anio
     * @param anio a buscar la fecha del dia de la madre
     * @return fecha del dia de la madre en ese anio
     */
    public static LocalDate obtenerDiaDeLaMadre(int anio) {
        if (anio < 1) {
            return null;
        }
        for (int i = 1; i < 8; i++) {
            LocalDate mesDeMayo = LocalDate.of(anio, 5, i);
            if (mesDeMayo.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                return mesDeMayo.plusDays(7);
            }
        }
        return null;
    }
}