package es.ies.puerto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sorting an ArrayList:
 * Create an ArrayList of strings.
 * Add 5 random strings to the list.
 * Sort the ArrayList alphabetically and print it.
 * Sort the ArrayList in reverse order and print it.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Exercise3 {
    static List<String> cardNames;
    public static void main(String[] args) {
        cardNames = new ArrayList<>();
        cardNames.add("Hog Rider");
        cardNames.add("Musketer");
        cardNames.add("Skeletons");
        cardNames.add("Miner");
        cardNames.add("P.E.K.K.A");
        Collections.sort(cardNames);
        System.out.println(cardNames);
        Collections.reverse(cardNames);
        System.out.println(cardNames);
    }
}
