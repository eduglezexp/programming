package es.ies.puerto;

/**
 * Estás cazando pokémon. Si el pokémon es de tipo Agua, Fuego o Planta, 
 * puedes usar la pokébola. Si es de cualquier otro tipo, no. 
 * Crea un programa que te diga si puedes atrapar al pokémon o no según su tipo.
 * @author eduglezexp
 */

import java.util.Scanner;

public class Ejercicio6 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {      
        System.out.println("Introduce el tipo de pokemon que desea cazar: ");
        String tipo = scanner.nextLine();
        tipo = tipo.toLowerCase();

        switch (tipo) {
            case "agua":
            case "fuego":
            case "planta":
                System.out.println("Puedes usar la pokébola");
                break;
            case "fantasma":
            case "hada":
            case "roca":
            case "lucha":
            case "bicho":
            case "normal":
            case "volador":
            case "veneno":
            case "tierra":
            case "acero":
            case "electrico":
            case "psiquico":
            case "hielo":
            case "dragon":
            case "siniestro":
                System.out.println("No puedes usar la pokébola");
                break;
            default:
                System.out.println("Introduce un tipo valido de pokemon");
                break;
        }
        scanner.close();
    }
}
