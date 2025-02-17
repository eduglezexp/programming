package es.ies.puerto.file.dos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokedex {

    public static void main(String[] args) throws Exception {
        FilePokedexXml operaciones = new FilePokedexXml();
        List<String> tipos = new ArrayList<>(Arrays.asList("Volador", "Dragon"));
        Pokemon pokemon = new Pokemon("6", "Rayquaza", tipos, "un pokemon");
        operaciones.addPokemon(pokemon);
    }
}
