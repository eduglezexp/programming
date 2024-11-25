package es.ies.puerto.ejercicio16;
import java.util.Objects;

/**
 * 16. Clase Fecha con Métodos de Validación
 * Crea una clase Fecha con atributos dia, mes y anio. Implementa métodos para validar 
 * si la fecha es correcta y para comparar dos fechas con equals().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    /**
     * Constructor por defecto
     */
    public Fecha() {
    }

    /**
     * Constructor con todas las propiedades
     * @param dia
     * @param mes
     * @param anio
     */
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Metodo para validar si la fecha es correcta
     * @return el dia si es valido
     */
    public boolean esFechaValida() {
        if (mes < 1 || mes > 12 || anio < 1) {
            return false;
        }
        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (esAnioBisiesto()) {
            diasPorMes[1] = 29; 
        }
        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    /**
     * Metodo para verificar si el anio es bisiesto
     * @return el anio 
     */
    private boolean esAnioBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    @Override
    public String toString() {
        return "Fecha [dia=" + dia + ", mes=" + mes + ", anio=" + anio + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fecha)) {
            return false;
        }
        Fecha fecha = (Fecha) o;
        return dia == fecha.dia && mes == fecha.mes && anio == fecha.anio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, anio);
    }    
}