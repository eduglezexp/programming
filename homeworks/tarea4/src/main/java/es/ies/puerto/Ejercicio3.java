package es.ies.puerto;

/**
 * Crea un array que almacene los nombres de 6 Pokémon de Ash. 
 * Recorre el array para mostrar los nombres con las siguientes reglas: 
 * Si el nombre del Pokémon contiene una "a", imprime "Pikachu lo elige". 
 * Si contiene una "i", imprime "¡Es muy fuerte!". 
 * De lo contrario, imprime el nombre normalmente.
 * @author eduglezexp
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        String pokemons[] = {"Pikachu", "Charizard", "Bulbasaur", "Noctowl", "Squirtle", "Greninja"};
        for (String pokemon : pokemons) {
            if (pokemon.contains("a") || pokemon.contains("A")) {
                System.out.println("Pikachu lo elige");
            } else if (pokemon.contains("i") || pokemon.contains("I")) {
                System.out.println("¡Es muy fuerte!");
            } else {
                System.out.println(pokemon);
            }
        }
    }
}
