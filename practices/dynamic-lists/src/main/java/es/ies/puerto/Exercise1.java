package es.ies.puerto;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create and manipulate an ArrayList:
 * Create an ArrayList of integers.
 * Add the numbers from 1 to 10 to the list.
 * Print the list.
 * Remove the 5th element.
 * Replace the second element with the number 99.
 * Print the final list.
 * Retrieve and print the element at index 4.
 * @author eduglezexp
 * @version 1.0.0
 */

public class Exercise1 {
    static List<Integer> numbers;
    public static void main(String[] args) {
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(numbers);
        removeNumber(4);
        setNumber(1, 99);
        System.out.println(numbers);
        addNumber(4, 5);
        System.out.println(numbers);
    }
    public static void addNumber(int index, int element) {
        numbers.add(index, element);
    }
    public static void removeNumber(int index) {
        numbers.remove(index);
    }
    public static void setNumber(int index, int element) {
        numbers.set(index, element);
    }
}