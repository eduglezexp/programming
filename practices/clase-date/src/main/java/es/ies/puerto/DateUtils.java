package es.ies.puerto;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class DateUtils {

    /**
     * Funcion para crear una nueva fecha
     * @return nueva fecha
     */
    public static Date createDate() {
        return new Date();
    }

    /**
     * Funcion para Compara dos fechas y determina si la primera es 
     * anterior a la segunda
     * @param date1 primera fecha a comparar
     * @param date2 segunda fecha a comparar
     * @return true/false
     */
    public static boolean compareDates(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.before(date2);
    }
    
    /**
     * Funcion para sumar un número específico de días a un objeto Date
     * @param date a la que se le va a sumar los dias
     * @param days que se le van a sumar a la fecha
     * @return fecha actualizada con los dias sumados
     */
    public static Date addDaysToDate(Date date, int days) {
        if (date == null) {
            return date;
        }
        long fechaMilisegundos = date.getTime()+days*24L*60*60*1000;
        return new Date(fechaMilisegundos);
    }

    /**
     * Funcion para convertir un objeto Date a una cadena de texto 
     * con formato yyyy-MM-dd
     * @param date
     * @return fecha formateada
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * Funcion que calcula la diferencia en días entre dos fechas
     * @param date1 para calcular la diferencia
     * @param date2 para calcular la diferencia
     * @return long con la diferencia en dias
     */
    public static long calculateDateDifference(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long diferenciaEnMilisegundos = Math.abs(time1 - time2);
        return diferenciaEnMilisegundos / (24 * 60 * 60 * 1000);
    }

    /**
     * Funcion que obtiene la fecha actual utilizando LocalDate
     * @return fecha actual
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * Funcion que crea un objeto LocalDate con un año, mes y día específicos
     * @param year de la fecha
     * @param month de la fecha
     * @param day de la fecha
     * @return fecha construida
     */
    public static LocalDate createSpecificLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    /**
     * Funcion para sumar un numero especifico de dias a un objeto LocalDate
     * @param date a la que se le suman los dias
     * @param days que se le van a sumar a la fecha
     * @return nueva fecha ajustado con los dias agregados
     */
    public static LocalDate addDays(LocalDate date, int days) {
        if (date == null) {
            return null;
        }
        return date.plusDays(days);
    }

    /**
     * Funcion que determina si una fecha LocalDate es anterior a otra
     * @param date1 fecha a comparar
     * @param date2 fecha de referencia
     * @return true/false
     */
    public static boolean isBefore(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return date1.isBefore(date2);
    }

    /**
     * Funcion que calcula la diferencia en anios, meses y días entre dos fechas LocalDate
     * @param start fecha inicail
     * @param end fecha final
     * @return la diferencia entre ambas fechas en anios, meses y día
     */
    public static Period calculatePeriodBetween(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            return null;
        }
        return Period.between(start, end);
    }

    /**
     * Funcion que obtiene la hora actual utilizando LocalTime
     * @return la hora actual
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();    
    }

    /**
     * Funcion que suma un numero especifico de minutos a un objeto LocalTime
     * @param time hora base 
     * @param minutes minutos a agregar (puede ser negativo)
     * @return hora con los minutos sumados
     */
    public static LocalTime addMinutes(LocalTime time, int minutes) {
        if (time == null) {
            return null;
        }
        return time.plusMinutes(minutes);
    }

    /**
     * Funcion que determina si una hora LocalTime ocurre antes que otra
     * @param time1 hora a comparar
     * @param time2 hora de referencia
     * @return true/false
     */
    public static boolean isTimeBefore(LocalTime time1, LocalTime time2) {
        if (time1 == null || time2 == null) {
            return false;
        }
        return time1.isBefore(time2);
    }

    /**
     * Funcion que obtiene la fecha y hora actual utilizando LocalDateTime
     * @return fecha y hora actual
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Funcion que suma un numero especifico de horas a un objeto LocalDateTime 
     * @param dateTime fecha y hora base
     * @param hours numero de horas a agregar (puede ser negativo)
     * @return hora actualizada
     */
    public static LocalDateTime addHours(LocalDateTime dateTime, int hours) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.plusHours(hours);
    }

    /**
     * Funcion que resta un numero especifico de meses a un objeto LocalDateTime
     * @param dateTime fecha y hora base
     * @param months numero de meses a restar
     * @return mes actualizado
     */
    public static LocalDateTime subtractMonths(LocalDateTime dateTime, int months) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.minusMonths(months);
    }

    /**
     * Funcion que obtinene la fecha y hora actuales en una zona horaria especifica
     * @param zoneId Identificador de zona horaria (por ejemplo, "Europe/Madrid")
     * @return fecha y hora actuales en un zona especifica
     */
    public static ZonedDateTime getZonedDateTime(String zoneId) {
        if (zoneId == null) {
            return null;
        }
        return ZonedDateTime.now(ZoneId.of(zoneId));
    }
    
    /**
     * Funcion que convierte un objeto ZonedDateTime de una zona horaria a otra
     * @param dateTime fecha y hora en la zona horaria original
     * @param targetZoneId identificador de la zona horaria de destino
     * @return fecha y hora convertida a otra zona horaria
     */
    public static ZonedDateTime convertZone(ZonedDateTime dateTime, String targetZoneId) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.withZoneSameInstant(ZoneId.of(targetZoneId));
    }

    /**
     * Funcion que obtiene el primer dia del mes de una fecha LocalDate dada
     * @param date fecha base
     * @return el primer dia del mes
     */
    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.withDayOfMonth(1);
    }
    
    /**
     * Funcion que obtiene el ultimo dia del mes de una fecha LocalDate dada
     * @param date fecha base
     * @return el ultimo dia del mes 
     */
    public static LocalDate getLastDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    /**
     * Funcion para verificar si el anio de una fecha LocalDate dada es bisiesto
     * @param date fecha base
     * @return true/false
     */
    public static boolean isLeapYear(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isLeapYear();
    }

    /**
     * Funcion que mide el tiempo de ejecución de una tarea representada como un objeto Runnable
     * @param task tarea cuya duracion se medira
     * @return duracion de la tarea en milisegundos (ms)
     */
    public static Duration measureExecutionTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        long durationInNanos = endTime - startTime;
        return Duration.ofNanos(durationInNanos);
    }

    /**
     * Funcion que convierte una cadena de texto en un objeto LocalDate utilizando un 
     * formato especifico
     * @param date fecha en formato texto
     * @param format formato esperado de la fecha (por ejemplo, "yyyy-MM-dd")
     * @return fecha con el nuevo formato
     * @throws DateTimeParseException
     */
    public static LocalDate parseDate(String date, String format) throws DateTimeParseException {
        if (date == null) {
            return null;
        }
        if (format.isEmpty() || format == null) {
            return null;
        }
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, formato);
    }

    public static void main(String[] args) {
        System.out.println("Vamos a probar los algoritmos");
    }
}