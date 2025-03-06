package es.ies.puerto;

/**
 * Dado el código Sith: "La paz es una mentira, solo hay pasión", 
 * crea un programa que cuente cuántas veces aparece la palabra "es".
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio23 {
    public static void main(String[] args) {
        String codigo = "La paz es una mentira, solo hay pasión";
        String[] palabras = codigo.split(" ");
        int contador = 0;
        for (String palabra : palabras) {
            if (palabra.contains("es")) {
                contador++;
            }
        }
        System.out.println(contador);
    }
}