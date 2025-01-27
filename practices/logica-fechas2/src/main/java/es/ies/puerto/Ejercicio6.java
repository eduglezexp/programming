package es.ies.puerto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio6 {
    
    /**
     * Funcion que dada una lista de eclipses solares historicos y futuros 
     * con sus fechas y horarios en UTC, encuentra el proximo eclipse solar,
     * dada una fecha
     * @param eclipses a buscar
     * @param fechaReferencia a partir de esta fecha se buscara el proximo 
     * eclipse que ocurrira cerca
     * @return la fecha exacta a la que ocurrira el eclipse
     */
    public static LocalDateTime obtenerProximoEclipse(List<LocalDateTime> eclipses, LocalDateTime fechaReferencia) {
        if (eclipses == null || fechaReferencia == null) {
            throw new IllegalArgumentException("La lista de eclipses y la fecha de referencia no pueden ser nulas");
        }
        LocalDateTime proximoEclipse = null;
        for (LocalDateTime eclipse : eclipses) {
            if (eclipse == null) {
                continue; 
            }
            if (eclipse.isAfter(fechaReferencia)) {
                if (proximoEclipse == null || eclipse.isBefore(proximoEclipse)) {
                    proximoEclipse = eclipse;
                }
            }
        }
        if (proximoEclipse == null) {
            throw new IllegalArgumentException("No hay eclipses futuros después de la fecha de referencia");
        }
        return proximoEclipse;
    }
}