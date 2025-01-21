package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;

/**
 * Clase del ejercicio 2
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {

    /**
     * Funcion encargada de calcular el numero de dias que tiene un mes, 
     * dada una fecha
     * @param anio de la fecha
     * @param mes de la fecha
     * @return dias que tiene el mes en especifico
     */
    public static int obtenerDiasDelMes(int anio, Month mes) {
        if (anio < 1 || mes == null) {
            return -1;
        }
        LocalDate localDate = LocalDate.of(anio, mes, 1);
        return localDate.lengthOfMonth();
    }
}
