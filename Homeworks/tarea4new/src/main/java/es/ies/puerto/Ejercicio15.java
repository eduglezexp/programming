package es.ies.puerto;

/**
 * En la Tierra Media, varios objetos mágicos han sido encontrados, pero los héroes están 
 * buscando específicamente el "Anillo Único". Escribe un programa que determine si el 
 * Anillo Único está en el inventario.
 * @author eduglezexp
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        String[] objetosMagicos = {"Palantir", "Anillo Único", "Espada de Elendil", "Capa Élfica"}; 
        String objetoBuscado = "Anillo Único"; 
        boolean encontrado = false;
        for (String objeto : objetosMagicos) {
            if (objeto.equals(objetoBuscado)) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El objeto " +objetoBuscado+ " esta en el inventario");
        }
        else {
            System.out.println("El objeto " +objetoBuscado+ " no esta en el inventario");
        }
    }
}
