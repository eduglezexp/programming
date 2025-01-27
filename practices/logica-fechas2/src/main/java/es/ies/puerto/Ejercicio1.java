package es.ies.puerto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    
    /**
     * Funcion que calcula la diferencia exacta en anios, meses, dias, horas, minutos 
     * y segundos entre dos fechas dadas
     * @param fechaInicio a calcular 
     * @param fechaFin a calcular
     * @return la diferencia entre dos fechas dadas 
     */
    public static LocalDateTime calcularDiferenciaFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            return null;
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException();
        }
        return fechaInicio.from(fechaFin);
    }
}
