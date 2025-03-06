package es.ies.puerto;

/**
 * Thanos ha recolectado gemas del infinito, pero quiere saber cuántas tiene de cada tipo. 
 * Escribe un programa que cuente cuántas gemas de "Poder", "Tiempo" y "Espacio" ha recolectado.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio20 {
    public static void main(String[] args) {
        String[] gemas = {"Poder", "Tiempo", "Espacio", "Tiempo", "Poder", "Poder"}; 
        int contadorPoder = 0;
        int contadorTiempo = 0;
        int contadorEspacio = 0; 
        for (String gema : gemas) {
            if (gema.equals("Poder")) {
                contadorPoder++;
            } else if (gema.equals("Tiempo")) {
                contadorTiempo++;
            } else if (gema.equals("Espacio")) {
                contadorEspacio++;
            }
        }
        System.out.println("Gemas de Poder: " +contadorPoder);
        System.out.println("Gemas del Tiempo: " +contadorTiempo);
        System.out.println("Gemas del Espacio: " +contadorEspacio);
    }
}
