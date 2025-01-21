package es.ies.puerto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.HashSet;

/**
 * Clase del ejercicio 4
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio4 {
    private static final Set<String> DIAS_FESTIVOS_NACIONALES = new HashSet<>();

    static {
        DIAS_FESTIVOS_NACIONALES.add("01-01"); 
        DIAS_FESTIVOS_NACIONALES.add("12-25");
    }

    /**
     * Funcion para comprueba si un dia es festivo nacional
     * @param fecha la fecha a comprobar
     * @return true/false
     */
    public static boolean esDiaFestivoNacional(LocalDate fecha) {
        if (fecha == null) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        String diaMes = fecha.format(formatter);
        return DIAS_FESTIVOS_NACIONALES.contains(diaMes);
    }
}