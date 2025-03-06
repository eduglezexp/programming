package es.ies.puerto.ejercicio19;

/**
 * 19. Clase Conversor con Métodos de Conversión estáticos
 * Crea una clase Conversor con métodos para convertir unidades de longitud 
 * (metros a pies__, kilómetros a millas). Usa toString() para mostrar el valor 
 * convertido.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio19 {
    public static void main(String[] args) {
        Conversor conversor = new Conversor(5, 7);
        System.out.println("Pies: " +conversor.metrosAPies());
        System.out.println("Millas: " +conversor.kilometrosAMillas());
    }
}
