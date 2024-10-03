package es.ies.puerto;

/**
 * Crea un array que represente los midiclorianos de 10 Jedi. Calcula la media de 
 * midiclorianos en el array. ¿Quién tiene más y quién tiene menos?
 * @author eduglezexp
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        // Array que representa los niveles de midiclorianos de 10 Jedi
        int[] midiclorianos = {15000, 12000, 20000, 18000, 22000, 17000, 14000, 25000, 16000, 13000};
        
        // Variables para calcular la suma, el máximo y el mínimo
        int suma = 0;
        int max = midiclorianos[0];
        int min = midiclorianos[0];
        int jediMax = 0; // índice del Jedi con más midiclorianos
        int jediMin = 0; // índice del Jedi con menos midiclorianos

        // Recorremos el array para calcular la suma, el máximo y el mínimo
        for (int i = 0; i < midiclorianos.length; i++) {
            suma += midiclorianos[i];

            // Verificamos si el valor actual es el máximo
            if (midiclorianos[i] > max) {
                max = midiclorianos[i];
                jediMax = i;
            }

            // Verificamos si el valor actual es el mínimo
            if (midiclorianos[i] < min) {
                min = midiclorianos[i];
                jediMin = i;
            }
        }

        // Calculamos la media de los midiclorianos
        double media = (double) suma / midiclorianos.length;

        // Imprimimos los resultados
        System.out.println("Media de midiclorianos: " + media);
        System.out.println("Jedi con más midiclorianos: Jedi " + (jediMax + 1) + " con " + max);
        System.out.println("Jedi con menos midiclorianos: Jedi " + (jediMin + 1) + " con " + min);
    }
}