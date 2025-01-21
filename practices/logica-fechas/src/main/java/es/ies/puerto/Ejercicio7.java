package es.ies.puerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

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
        LocalDate primerDiaDeMayo = LocalDate.of(anio, 5, 1);
        int diasHastaElPrimerDomingo = (7 - primerDiaDeMayo.getDayOfWeek().getValue()) % 7;
        LocalDate primerDomingo = primerDiaDeMayo.plusDays(diasHastaElPrimerDomingo);
        LocalDate segundoDomingo = primerDomingo.plusDays(7);
        return segundoDomingo;
    }
}