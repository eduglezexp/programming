package es.ies.puerto;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {

    /**
     * Funcion para encontrar el ultimo viernes de cada mes, dado un anio
     * @param anio a calcular 
     * @return una lista de las fechas
     */ 
    public static List<LocalDate> obtenerUltimosViernes(int anio) {
        List<LocalDate> ultimosViernes = new ArrayList<>();
        if (anio <=0) {
            return ultimosViernes;
        }
        // Iteramos sobre cada mes del año
        for (Month mes : Month.values()) {
            // Obtener el último día del mes
            LocalDate ultimoDiaDelMes = LocalDate.of(anio, mes, mes.length(LocalDate.of(anio, mes, 1).isLeapYear()));

            // Obtener el último viernes
            LocalDate ultimoViernes = ultimoDiaDelMes;

            // Retroceder hasta el viernes más cercano
            while (ultimoViernes.getDayOfWeek().getValue() != 5) { // 5 representa el viernes
                ultimoViernes = ultimoViernes.minusDays(1);
            }

            // Añadir el último viernes a la lista
            ultimosViernes.add(ultimoViernes);
        }
        return ultimosViernes;
    }
}