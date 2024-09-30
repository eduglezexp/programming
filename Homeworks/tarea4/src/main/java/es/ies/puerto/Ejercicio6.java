package es.ies.puerto;

/**
 * Crea un array que contenga los nombres de los 7 superhéroes más poderosos 
 * según tu criterio. Luego, usa un algoritmo de ordenación (por ejemplo, burbuja) 
 * para ordenarlos alfabéticamente.
 * @author eduglezexp
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        String[] superheroes = {"Deadpool", "Batman", "Spiderman", "Deku", "Darth Vader", "Tanjiro", "ken kaneki"};
        for (int i = 0; i < superheroes.length - 1; i++) {
            for (int j = 0; j < superheroes.length - 1 - i; j++) {
                if (superheroes[j].compareTo(superheroes[j + 1]) > 0) {
                    String temporal = superheroes[j];
                    superheroes[j] = superheroes[j + 1];
                    superheroes[j + 1] = temporal;
                }
            }       
        }
        for (String superheroe : superheroes) {
            System.out.println(superheroe);
        }
    }
}
