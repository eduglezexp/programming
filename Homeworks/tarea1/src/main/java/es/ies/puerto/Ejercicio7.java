package es.ies.puerto;

/**
 * Escribe un programa que convierta grados Celsius a 
 * Fahrenheit. Usa variables de tipo double para los cálculos.
 * @author eduglezexp
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        double dCelsius = 10;
        double dFahrenheit;
        dFahrenheit = ((dCelsius * 9 / 5) + 32);

        System.out.println(dCelsius+ "Celsius, son: " +dFahrenheit+ "Fahrenheit");
    }
}