package es.ies.puerto;

import java.util.Random;

/**
 * Crea dos arrays de enteros que representen la vida de dos equipos Pokémon. En cada turno, 
 * un Pokémon de cada equipo pierde una cantidad aleatoria de vida. El juego termina cuando 
 * todos los Pokémon de un equipo son derrotados.
 * @author eduglezexp
 */

public class Ejercicio10 {
    static Random random = new Random();
    public static void main(String[] args) {
        int[] vidaPokemons1 = {100, 257, 68, 232, 140, 32};
        int[] vidaPokemons2 = {300, 123, 78, 6, 252, 43};
        boolean equipoMuerto1 = false;
        boolean equipoMuerto2 = false;
        do {
            System.out.println("Vida de los pokemons del primer Equipo:");
            for (int i = 0; i < vidaPokemons1.length; i++) {
                System.out.println("Pokemon " +(i + 1)+ ": " +vidaPokemons1[i]+ " vida");
            }
            System.out.println("Vida de los pokemons del segundo Equipo:");
            for (int i = 0; i < vidaPokemons2.length; i++) {
                System.out.println("Pokemon " +(i + 1)+ ": " +vidaPokemons2[i]+ " vida");
            }
            int indexPokemon1 = random.nextInt(vidaPokemons2.length);
            while (vidaPokemons2[indexPokemon1] <= 0) {
                indexPokemon1 = random.nextInt(vidaPokemons2.length);
            }
            int danioPokemon1 = random.nextInt(50) + 1;
            vidaPokemons2[indexPokemon1] -= danioPokemon1;
            if (vidaPokemons2[indexPokemon1] < 0) {
                vidaPokemons2[indexPokemon1] = 0;
            }
            System.out.println("El Pokémon del equipo 1 ataca al Pokémon " + (indexPokemon1 + 1) + " del equipo 2 causando " + danioPokemon1 + " de daño.");
            int indexPokemon2 = random.nextInt(vidaPokemons1.length);
            while (vidaPokemons1[indexPokemon2] <= 0) {
                indexPokemon2 = random.nextInt(vidaPokemons1.length);
            }
            int danioPokemon2 = random.nextInt(50) + 1;
            vidaPokemons1[indexPokemon2] -= danioPokemon2;
            if (vidaPokemons1[indexPokemon2] < 0) {
                vidaPokemons1[indexPokemon2] = 0;
            }
            System.out.println("El Pokémon del equipo 2 ataca al Pokémon " + (indexPokemon2 + 1) + " del equipo 1 causando " + danioPokemon2 + " de daño.");
            equipoMuerto1 = true;
            for (int vidaPokemon1 : vidaPokemons1) {
                if (vidaPokemon1 > 0) {
                    equipoMuerto1 = false;
                    break;

                }
            }
            equipoMuerto2 = true;
            for (int vidaPokemon2 : vidaPokemons2) {
                if (vidaPokemon2 > 0) {
                    equipoMuerto2 = false;
                    break;
                }
            }
        } while (!equipoMuerto1 && !equipoMuerto2);
        if (equipoMuerto1) {
            System.out.println("El equipo 1 ha sido derrotado. El equipo 2 gana!");
        } else {
            System.out.println("El equipo 2 ha sido derrotado. El equipo 1 gana!");
        }
    }
}