package es.ies.puerto;

/**
 * En un RPG, los personajes pueden subir de nivel incrementando su experiencia. 
 * Escribe un programa que multiplique la experiencia de cada personaje por 1.5 
 * para simular su mejora tras una batalla.
 * @author eduglezexp
 */

public class Ejercicio17 {
    public static void main(String[] args) {
        int[] experiencias = {100, 200, 150, 120}; 
        double multiplicador = 1.5;
        int[] nuevaExperiencia = new int[experiencias.length];
        for (int i = 0; i < nuevaExperiencia.length; i++) {
            nuevaExperiencia[i] = (int) (experiencias[i] * multiplicador); 
        }
        for (int experiencia : nuevaExperiencia) {
            System.out.print(experiencia+ " ");
        }
    }
}
