package es.ies.puerto;

/**
 * Ejercicio 2: Algoritmo - Cálculo de Velocidad de un Cuerpo
 * Descripción: Crea un programa en Java que permita calcular la velocidad final de 
 * un cuerpo en movimiento uniformemente acelerado. Los datos de entrada son:
 *  Velocidad inicial ( v0 ) (en metros por segundo).
 *  Aceleración ( a ) (en metros por segundo al cuadrado).
 *  Tiempo ( t ) (en segundos).
 * La fórmula de velocidad final es: [ v = v0 + a * t ]
 * A tener en cuenta:
 *  Solicita al usuario los tres valores y calcula la velocidad final.
 *  Considera las restricciones de unidades y muestra la velocidad final en m/s.
 *  Ten en cuenta los tipos de datos para realizar los calculos.
 * Ejemplo de salida:
 *  Entrada: ( v0 = 5 ), ( a = 3 ), ( t = 10 ) 
 *  Salida: La velocidad final es: 35.0 m/s.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        float velocidadInicial = 5;
        float aceleracion = 3;
        float tiempo = 10;
        System.out.println(calcularVelocidadFinal(velocidadInicial, aceleracion, tiempo)+ " m/s");        
    }

    /**
     * Metodo para calcular la velocidad final 
     * @param velocidadInicial
     * @param aceleracion
     * @param tiempo
     * @return float de la velocidad final
     */
    public static float calcularVelocidadFinal(float velocidadInicial, float aceleracion, float tiempo) {
        return velocidadInicial + aceleracion * tiempo;
    }
}
