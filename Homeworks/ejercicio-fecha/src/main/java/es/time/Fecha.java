package es.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Fecha {

    /**
     * Metodo para obtener la fecha y hora actual
     * @return fecha y hora actual
     */
    public LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    /**
     * Metodo para obtener la fecha actual
     * @return fecha actual
     */
    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    /**
     * Metodo para convertir un String a un LocalDate
     * @param fechaStr String a formatear
     * @param formato que se le va a aplicar
     * @return fecha formateada
     */
    public LocalDate convertirStringALocalDate(String fechaStr, String formato) {
        if (fechaStr == null || fechaStr.isEmpty()) {
            return null;
        }
        if (formato == null || formato.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(fechaStr, formatter);
    }

    /**
     * Metodo para formatear una fecha
     * @param fecha a formatear
     * @param formato a aplicar a la fecha 
     * @return fecha formateada
     */
    public String formatearFecha(LocalDate fecha, String formato) {
        if (fecha == null) {
            return null;
        }
        if (formato == null || formato.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formatter);
    }

    /**
     * Metodo para calcular la edad
     * @param fechaNacimiento a la que se le va a calcular
     * @return edad actual
     */
    public int calcularEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            return -1;
        }
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }

    /**
     * Metodo para sumar los dias
     * @param fecha a la que se le va a sumar los dias
     * @param dias a sumar a la fecha
     * @return fecha actualizada con la suma de dias
     */ 
    public LocalDate sumarDias(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        return fecha.plusDays(dias);
    }

    /**
     * Metodo para restar los dias
     * @param fecha a la que se le va a restar los dias
     * @param dias a restar a la fecha
     * @return fecha actualizada con la resta de dias
     */
    public LocalDate restarDias(LocalDate fecha, int dias) {
        if (fecha == null) {
            return null;
        }
        return fecha.minusDays(dias);
    }

    /**
     * Metodo para sumar los meses
     * @param fecha a la que se le va a sumar los meses
     * @param meses a sumar a la fecha
     * @return fecha actualizada con la suma de meses
     */ 
    public LocalDate sumarMeses(LocalDate fecha, int meses) {
        if (fecha == null) {
            return null;
        }
        return fecha.plusMonths(meses);
    }

    /**
     * Metodo para restar los meses
     * @param fecha a la que se le va a restar los meses
     * @param meses a restar a la fecha
     * @return fecha actualizada con la resta de meses
     */
    public LocalDate restarMeses(LocalDate fecha, int meses) {
        if (fecha == null) {
            return null;
        }
        return fecha.minusMonths(meses);
    }

    /**
     * Metodo que calcular la diferencia de dias
     * @param fecha1 a calcular la diferencia
     * @param fecha2 a calcular la diferencia
     * @return diferencia de dias
     */
    public long diferenciaDias(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1l;
        }
        return Period.between(fecha1, fecha2).getDays();    
    }

    /**
     * Metodo que calcular la diferencia de meses
     * @param fecha1 a calcular la diferencia
     * @param fecha2 a calcular la diferencia
     * @return diferencia de meses
     */
    public long diferenciaMeses(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1l;
        }
        return Period.between(fecha1, fecha2).getMonths(); 
    }

    /**
     * Metodo que calcular la diferencia de anios
     * @param fecha1 a calcular la diferencia
     * @param fecha2 a calcular la diferencia
     * @return diferencia de anios
     */
    public long diferenciaAnios(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1 == null || fecha2 == null) {
            return -1l;
        }
        return Period.between(fecha1, fecha2).getYears(); 
        }

    public int compararFechas(LocalDate fecha1, LocalDate fecha2) {
        return 1000;
    }

    public boolean esBisiesto(LocalDate fecha) {
        return fecha.isLeapYear();
    }

    public String obtenerDiaSemana(LocalDate fecha) {
        return null;
    }

    public int obtenerDiaDelAnio(LocalDate fecha) {
        return -1;
    }

    public LocalDate obtenerPrimerDiaMes(LocalDate fecha) {
        return null;
    }

    public LocalDate obtenerUltimoDiaMes(LocalDate fecha) {
        return null;
    }

    public ZonedDateTime convertirZonaHoraria(LocalDateTime fechaHora, String zona) {
        return null;
    }


    public Duration calcularDiferenciaHorasMinutos(LocalDateTime inicio, LocalDateTime fin) {
        return null;
    }
}