package es.ies.puerto.ejercicio37;

/**
 * 37. Clase Partido con Equipos y Resultados
 * Crea una clase Partido con atributos equipoLocal, equipoVisitante, y resultado. 
 * Implementa métodos para actualizar el resultado y usar toString() para mostrar 
 * los detalles del partido.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String resultado; 

    /**
     * Constructor por defecto
     */
    public Partido() {
    }

    /**
     * Constrctor con las propiedades equipoLocal y equipoVisitante
     * @param equipoLocal
     * @param equipoVisitante
     */
    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = "0-0";
    }

    /**
     * Getters and Setters
     */
    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void actualizarResultado(int golesLocal, int golesVisitante) {
        this.resultado = golesLocal + "-" + golesVisitante;
    }

    @Override
    public String toString() {
        return "Partido: " + equipoLocal + " vs " + equipoVisitante + ", Resultado: " + resultado;
    }
}