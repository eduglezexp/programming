package es.ies.puerto;

/**
 * Escribe un programa que convierta grados Celsius a 
 * Fahrenheit. Usa variables de tipo double para los cálculos.
 * @author eduglezexp
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        double dgradosCelsius = 10;
        double celsiusToFahrenheit;
        celsiusToFahrenheit = ((dgradosCelsius * 9 / 5) + 32);

        System.out.println(dgradosCelsius+ "Celsius, son: " +celsiusToFahrenheit+ "Fahrenheit");
    }
}