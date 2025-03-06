package es.ies.puerto;

/**
 * Dado un hechizo como "Expecto Patronum", crea un programa que 
 * verifique si comienza con "Expecto" y termina con "Patronum".
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio22 {
    public static void main(String[] args) {
        String hechizo = "Expecto Patronum";
        boolean contiene = false;
        if (hechizo.startsWith("Expecto") && hechizo.endsWith("Patronum")) {
            contiene = true;
        }
        System.out.println(contiene);
    }
}