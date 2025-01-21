package es.ies.puerto;

import java.time.LocalDate;

/**
 * Clase del ejercicio 10
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    
    public static long calcularDiferenciaEnDias(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1; 
        }
        long diferencia = 0;
        LocalDate inicio = fecha1.isBefore(fecha2) ? fecha1 : fecha2;
        LocalDate fin = fecha1.isBefore(fecha2) ? fecha2 : fecha1;
        while (!inicio.isEqual(fin)) {
            inicio = inicio.plusDays(1);
            diferencia++;
        }
        if (fecha1.isAfter(fecha2)) {
            diferencia = -diferencia;
        }
        return diferencia;
    }
}