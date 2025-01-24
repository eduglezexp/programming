package es.ies.puerto;

import java.time.LocalDate;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Ejercicio4 {
    
    public static List<LocalDate> obtenerDiasBisiestos(int aniosFuturos) {
        if (aniosFuturos < 1) {
            throw new IllegalArgumentException("El número de años futuros debe ser mayor a 0.");
        }
        List<LocalDate> bisiestos = new ArrayList<>();
        LocalDate fecha = LocalDate.of(LocalDate.now().getYear(), 2, 1);
        for (int i = 1; i < aniosFuturos+1; i++) {
            if (fecha.plusYears(i).isLeapYear()) {
                bisiestos.add(LocalDate.of(fecha.getYear()+i, 2, 29));
            }
        } 
        return bisiestos;
    }
}
