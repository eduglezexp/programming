package es.ies.examen;

public class Ejercicio1 {

    /**
     * Metodo para sumar los numeros d un array
     * @param array
     * @return suma
     */
    public int sumArray(int[] array) {
        int suma = 0;
        for (int numero : array) {
            suma += numero;
        }
        return suma;
    }
}