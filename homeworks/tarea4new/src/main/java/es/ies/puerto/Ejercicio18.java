package es.ies.puerto;

/**
 * En una carrera de Starfighters, los pilotos han registrado sus tiempos en segundos. 
 * Escribe un programa que ordene los tiempos de menor a mayor para mostrar quién ha 
 * sido el más rápido.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio18 {
    public static void main(String[] args) {
        int[] tiempos = {350, 280, 420, 310};
        for (int i = 0; i < tiempos.length - 1 ; i++) {
            for (int j = 0; j < tiempos.length - 1 - i; j++) {
                if (tiempos[j] > tiempos[j + 1]) {
                    int temporal = tiempos[j];
                    tiempos[j] = tiempos[j + 1];
                    tiempos[j + 1] = temporal;
                }
            }
        }
        for (int tiempo : tiempos) {
            System.out.print(tiempo + " ");
        }
    }
}
