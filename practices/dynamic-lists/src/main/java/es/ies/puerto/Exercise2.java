package es.ies.puerto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find duplicates in an ArrayList:
 * create an ArrayList of integers with some duplicates.
 * Write a method to find and print all duplicate numbers in the list.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Exercise2 {
    static List<Integer> numbers;
    public static void main(String[] args) {
        numbers = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 5, 6, 6, 2));
        findDuplicates(numbers);
    }

    public static void findDuplicates(List<Integer> numbers) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j)) && !duplicates.contains(numbers.get(i))) {
                    duplicates.add(numbers.get(i));
                }
            }
        }
        System.out.println(duplicates);
    }
}
