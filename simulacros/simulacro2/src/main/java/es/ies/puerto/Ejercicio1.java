package es.ies.puerto;

/**
 * Ejercicio 1: Algoritmo - Verificación de Fecha y Año Bisiesto
 * Descripción: Escribe un programa en Java implemente una función que recibe tres 
 * enteros (dia,mes,anio) y verifique:
 * La función devuelve true si la fecha es correcta, y false en cualquier otro caso.
 * A tener en cuenta:
 *  Una fecha es válida si el día se encuentra dentro del rango de días del mes 
 * correspondiente, y si es año bisiesto en el caso de febrero (29 días).
 *  Un año es bisiesto si es divisible por 4, pero no por 100, excepto cuando 
 * también es divisible por 400.
 * Ejemplo de salida:
 *  Entrada: 29/02/2020 → Salida: Fecha válida, año bisiesto.
 *  Entrada: 31/04/2023 → Salida: Fecha no válida.
 * La función se llama isBisiesto(int dia, int mes, int anio), y retorna true/false.
 * Un año es bisiesto si es divisible por 4 (anio % 4 == 0). Si el año es divisible 
 * por 100, también debe ser divisible por 400 para ser bisiesto. Esto se verifica 
 * con anio % 100 != 0 || anio % 400 == 0.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        int dia1 = 29;
        int mes1 = 02;
        int anio1 = 2020;
        System.out.println(verificarFecha(dia1, mes1, anio1));
        int dia2 = 31;
        int mes2 = 04;
        int anio2 = 2023;
        System.out.println(verificarFecha(dia2, mes2, anio2));
    }

    /**
     * Metodo para verificar si una fecha es valida o no
     * @param dia
     * @param mes
     * @param anio
     * @return true/false
     */
    public static boolean verificarFecha(int dia, int mes, int anio) {
        if (dia < 1 || mes > 12 || anio < 1) {
            return false;
        }
        int[] diaPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (esBisiesto(anio)) {
            diaPorMes[1] = 29;
        }
        return dia >= 1 && dia <= diaPorMes[mes - 1];
    } 

    /**
     * Metodo para verificar si el anio es bisiesto o no
     * @param anio
     * @return true/false
     */
    public static boolean esBisiesto(int anio) {
        if (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0) {
            return true;
        }
        return false;
    }
}