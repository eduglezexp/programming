package es.ies.puerto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Duration;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    
    /**
     * Funcion para calcular cuantos milisegundos ha vivido una persona
     * @param fechaNacimiento de la persona 
     * @return los milisegundos vividos en anios bisiestos
     */
    public static long calcularEdadEnMilisegundos(LocalDateTime fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        LocalDateTime ahora = LocalDateTime.now();
        Duration duracion = Duration.between(fechaNacimiento, ahora);
        return duracion.toMillis();
    }
}
