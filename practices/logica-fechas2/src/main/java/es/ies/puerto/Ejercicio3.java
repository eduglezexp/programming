package es.ies.puerto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio3 {
    
    /**
     * Funcion para convertir zonas horarias 
     * @param fechaHora de la fecha
     * @param zonaOrigen de la fecha
     * @param zonasDestino de la fecha
     * @return fecha convertida a la otra zona horaria
     */
    public static Map<String, ZonedDateTime> convertirZonasHorarias(
        LocalDateTime fechaHora, ZoneId zonaOrigen, List<ZoneId> zonasDestino) {
        zonaOrigen = ZoneId.of("America/New_York");
        zonasDestino = List.of(
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("Europe/London"),
                ZoneId.of("Australia/Sydney")
        );
        return null;
    
    }
}