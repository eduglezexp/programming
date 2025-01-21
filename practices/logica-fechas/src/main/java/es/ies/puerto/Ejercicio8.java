package es.ies.puerto;

import java.time.LocalDate;

/**
 * Clase del ejercicio 8
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {

    /**
     * Funcion que calcula cuantos dias han pasado desde 
     * el inicio de anio hasta una fecha dada
     * @param fecha para calcular
     * @return dias transcurridos 
     */
    public static long diasDesdeInicioDelanio(LocalDate fecha) {
        if (fecha == null) {
            return -1; 
        }
        return fecha.getDayOfYear();
    }
}