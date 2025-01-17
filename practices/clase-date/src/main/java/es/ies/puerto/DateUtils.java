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
     * @return long con la diferencia
     */
    public static long calculateDateDifference(Date date1, Date date2) {
        return 0l;
    }

    public static LocalDate getCurrentLocalDate() {
        return null;
    }

    public static LocalDate createSpecificLocalDate(int year, int month, int day) {
        return null;
    }

    public static LocalDate addDays(LocalDate date, int days) {
        return null;
    }

    public static boolean isBefore(LocalDate date1, LocalDate date2) {
        return false;
    }

    public static Period calculatePeriodBetween(LocalDate start, LocalDate end) {
        return null;
    }

    public static LocalTime getCurrentLocalTime() {
        return null;    
    }

    public static LocalTime addMinutes(LocalTime time, int minutes) {
        return null;
    }

    public static boolean isTimeBefore(LocalTime time1, LocalTime time2) {
        return false;
    }

    
    public static LocalDateTime getCurrentLocalDateTime() {
        return null;
    }

    public static LocalDateTime addHours(LocalDateTime dateTime, int hours) {
        return null;
    }

    public static LocalDateTime subtractMonths(LocalDateTime dateTime, int months) {
        return null;
    }

    public static ZonedDateTime getZonedDateTime(String zoneId) {
        return null;
    }

    public static ZonedDateTime convertZone(ZonedDateTime dateTime, String targetZoneId) {
        return null;
    }

    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return null;
    }

    public static LocalDate getLastDayOfMonth(LocalDate date) {
        return null;
    }

    public static boolean isLeapYear(LocalDate date) {
        return false;
    }

    public static Duration measureExecutionTime(Runnable task) {
        return null;
    }

    public static LocalDate parseDate(String date, String format) throws DateTimeParseException {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Vamos a probar los algoritmos");
    }
}