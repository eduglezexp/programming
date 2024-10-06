package es.ies.puerto;

/**
 * Se han registrado los puntajes de las casas de Hogwarts en el Torneo de Magia. 
 * Cada casa recibe una medalla (Oro, Plata o Bronce) según su puntuación. Escribe 
 * un programa que cuente cuántas medallas de cada tipo ha ganado una casa.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio14 {
    public static void main(String[] args) {
        String[] medallas = {"Oro", "Plata", "Bronce", "Oro", "Oro", "Plata"}; 
        int contadorOro = 0;
        int contadorPlata = 0;
        int contadorBronce = 0;
        for (String medalla : medallas) {
            if (medalla.equals("Oro")) {
                contadorOro++;
            } else if (medalla.equals("Plata")) {
                contadorPlata++;
            } else if (medalla.equals("Bronce")) {
                contadorBronce++;
            }
        }
        System.out.println("Medallas");
        System.out.println("Oro: " +contadorOro);
        System.out.println("Plata: " +contadorPlata);
        System.out.println("Bronce: " +contadorBronce);
    }
}
