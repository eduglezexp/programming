package es.ies.puerto;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic HashMap operations:
 * Create a HashMap that maps strings to integers.
 * Add the following key-value pairs: ("apple", 1), ("banana", 2), ("orange", 3).
 * Print the value associated with the key "banana".
 * Remove the key "orange" and print the updated HashMap.
 * Check if the key "apple" exists in the map.
 * Print all the keys in the HashMap.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Exercise4 {
    static Map<String,Integer> fruits;
    public static void main(String[] args) {
        fruits = new HashMap<>();
        fruits.put("apple", 1);
        fruits.put("banana", 2);
        fruits.put("orange", 3);
        System.out.println(fruits.get("banana"));
        fruits.remove("orange");
        System.out.println(fruits);
        System.out.println(fruits.containsKey("apple"));
        System.out.println(fruits.keySet());
    }
}
