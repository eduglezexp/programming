package es.ies.puerto;

/**
 * Crea un array de caracteres que represente una frase. Luego, cifra el mensaje 
 * reemplazando cada carácter por el siguiente en el alfabeto (por ejemplo, 'a' 
 * se convierte en 'b', 'z' se convierte en 'a').
 * @author eduglezexp
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        String frase = "hola vida";
        char[] caracteres = frase.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            if (Character.isLetter(caracteres[i])) {
                if (caracteres[i] == 'z') {
                    caracteres[i] = 'a'; 
                } else if (caracteres[i] == 'Z') {
                    caracteres[i] = 'A'; 
                } else {
                    caracteres[i] = (char) (caracteres[i] + 1);
                }
            }
        }
        String fraseCifrada = new String(caracteres);
        System.out.println("Frase cifrada: " + fraseCifrada);
    }
}
