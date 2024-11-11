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

public class Consejo {
    private Mago[] magos;
    private int totalMagos;

    public Consejo() {
        totalMagos = 0;
        this.magos = new Mago[10];
    }

    public Consejo(int numeroMagos) {
        totalMagos = 0;
        this.magos = new Mago[numeroMagos];
    }

    public boolean agregarMago(Mago mago) {
        if (mago == null) {
            return false;
        }
        if (totalMagos >= magos.length) {
            return false;
        }
        magos[totalMagos] = mago;
        totalMagos++;
        return true;
    }

    public boolean deleteMago(Mago mago) {
        if (mago == null) {
            return false;
        }
        for (int i = 0; i < magos.length; i++) {
            if (magos[i].equals(mago)) {
                magos[i] = null;
                totalMagos--;
                ordenarLista();
                return true;
            }
        }
        return false;
    }

    public void ordenarLista() {
        int indice = 0;
        for (int i = 0; i < magos.length; i++) {
            if (magos[i] != null) {
                magos[i] = magos[indice];
                indice++;
            }
        }
    }
}