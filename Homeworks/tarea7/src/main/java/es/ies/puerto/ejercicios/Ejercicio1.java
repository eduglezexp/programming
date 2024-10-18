package es.ies.puerto.ejercicios;

import es.ies.puerto.clases.Superheroe;

/**
 * Crea una clase Superheroe que tenga como atributos el nombre, alias y habilidad principal. 
 * Sobrescribe toString() para imprimir la información del superhéroe y equals() para comparar 
 * superhéroes en función de su alias.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Superheroe hombreDeHierro = new Superheroe("Tony Stark", "Hombre de Hierro", 
        "Tecnologia avanzada");
        Superheroe spiderman = new Superheroe("Peter Parker", "Iron Man", 
        "Sentido aracnido");
        System.out.println(findEqualsIronMan(hombreDeHierro));
        System.out.println(findEqualsIronMan(spiderman));
    }

    public static String findEqualsIronMan(Superheroe superheroe) {
        Superheroe ironMan = new Superheroe("Tony Stark", "Iron Man", 
        "Tecnologia avanzada");
        if (ironMan.equals(superheroe)) {
            return "Iron Man y " +superheroe.getAlias()+ " son el mismo superheroe.";
        } 
        return "Iron Man y " +superheroe.getAlias()+ " NO son el mismo superheroe.";
    }
}