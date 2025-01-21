package es.ies.puerto;

import java.time.LocalDate;

/**
 * Clase del ejercicio 8
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio8 {
    public static long diasDesdeInicioDelanio(LocalDate fecha) {
        if (fecha == null) {
            return -1; 
        }
        LocalDate inicioAnio = LocalDate.of(fecha.getYear(), 1, 1);
        int diasTranscurridos = 0;
        LocalDate fechaActual = inicioAnio;
        while (!fechaActual.isEqual(fecha)) {
            diasTranscurridos++;
            fechaActual = fechaActual.plusDays(1);
        }
        return diasTranscurridos + 1;
    }
}