package es.ies.puerto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class Ejercicio1 {
    
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
