package es.ies.puerto;

/**
 * Ejercicio 5: Gestión de Energía Mágica
 * Descripción El Consejo de Magos de la Antigua Orden te ha encomendado una 
 * importante misión: desarrollar un sistema que permita gestionar y analizar 
 * la lista de magos del consejo según sus niveles de poder mágico y maná. 
 * ¡Los magos de mayor energía serán seleccionados para la misión final de 
 * protección del reino!.
 * Objetivo Crea una clase Mago que represente a cada miembro del consejo con sus 
 * atributos mágicos y que permita realizar las siguientes operaciones:
 *  Mostrar todos los magos del consejo, junto con sus nombres, niveles de poder 
 *  mágico y niveles de maná.
 *  Encontrar al mago con el mayor maná: El consejo necesita saber quién puede 
 *  lanzar la mayor cantidad de hechizos.
 *      Mago mayorCantidadHechizos() {}
 *  Encontrar al mago con el mayor poder mágico: El mago de mayor poder será el 
 *  líder de la misión de defensa.
 *      Mago mayorPoderMagico() {}
 * @author eduglezexp
 * @version 1.0.0
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        Consejo consejo = new Consejo();
        Mago mago1 = new Mago("Mago1", 49, 300);
        Mago mago2 = new Mago("Mago2", 34, 120);
        Mago mago3 = new Mago("Mago3", 34, 120);
        consejo.agregarMago(mago1);
        consejo.agregarMago(mago2);
        consejo.agregarMago(mago3);
        System.out.println(consejo);
        consejo.deleteMago(mago2);
        System.out.println(consejo);
        consejo.agregarMago(mago2);
        System.out.println(consejo);
        System.out.println(consejo.mayorCantidadHechizos());
        System.out.println(consejo.mayorPoderMagico());
    }
}