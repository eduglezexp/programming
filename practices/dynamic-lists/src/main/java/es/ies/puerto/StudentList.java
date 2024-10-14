package es.ies.puerto;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList of custom objects:
 * Create a class called Student with fields name and id.
 * Create an ArrayList of Student objects.
 * Add 5 Student objects to the list.
 * Print the names and IDs of all students.
 * Find a student with a specific id and print their information.
 * @author eduglezexp
 * @version 1.0.0
 */

public class StudentList {
    private int id;
    private String name;
    static List<StudentList> students;
    public StudentList() {
        
    }
    public StudentList(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
    public static void main(String[] args) {
        students = new ArrayList<>();
        students.add(new StudentList(1, "Alberto"));
        students.add(new StudentList(2, "Antonio"));
        students.add(new StudentList(3, "Eduardo"));
        students.add(new StudentList(4, "Pepe"));
        students.add(new StudentList(5, "David"));
        System.out.println(students);
        int id = 1;
        findStundentById(id);
    }
    public static void findStundentById(int id) {
        boolean studentFound = false;
        for (StudentList student : students) {
            if (student.getId() == id) {
                System.out.println(student);
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}