package es.ies.puerto;

/**
 * Crea un programa que convierta un poder de pelea (entero) en un string y 
 * viceversa usando los métodos Integer.parseInt() y Integer.toString().
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio13 {
    public static void main(String[] args) {
        String poderString = "5000";
        int poderInt = 4000;
        int poderParseInt = Integer.parseInt(poderString);
        String poderToString = Integer.toString(poderInt);
        System.out.println(poderParseInt);
        System.out.println(poderToString);
    }
}