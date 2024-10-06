package es.ies.puerto;

/**
 * En la arena de gladiadores, se ha realizado una evaluación de las habilidades de combate. 
 * Escribe un programa que ordene las puntuaciones de los gladiadores de menor a mayor para 
 * ver quién es el mejor combatiente.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio10 {
    public static void main(String[] args) {
        int[] rankings = {300, 500, 200, 400, 100};
        for (int i = 0; i < rankings.length - 1; i++) {
            for (int j = 0; j < rankings.length - 1 - i; j++) {
                if (rankings[j] > rankings[j + 1]) {
                    int temporal = rankings[j];
                    rankings[j] = rankings[j + 1];
                    rankings[j + 1] = temporal;
                }
            }
        }
        for (int ranking : rankings) {
            System.out.print(ranking+ " ");
        }
    }
}
