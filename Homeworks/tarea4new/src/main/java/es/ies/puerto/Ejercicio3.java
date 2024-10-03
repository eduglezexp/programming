package es.ies.puerto;

/**
 * Un grupo de guerreros ha sido evaluado por su nivel de poder de ataque. 
 * Escribe un programa que determine quién es el héroe más fuerte y el más débil.
 * @author eduglezexp
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] nivelesDeAtaque = {300, 150, 500, 200, 250}; 
        int maximo = nivelesDeAtaque[0];
        int minimo = nivelesDeAtaque[0];
        for (int i = 1; i < nivelesDeAtaque.length; i++) {
            if (nivelesDeAtaque[i] > maximo) {
                maximo = nivelesDeAtaque[i];
            }
            if(nivelesDeAtaque[i] < minimo){
                minimo = nivelesDeAtaque[i];
            }
        }
        System.out.println("Valor maximo: " +maximo);
        System.out.println("Valor minimo: " +minimo);
    }
}
