package es.ies.puerto;

import java.util.HashMap;
import java.util.Map;

/**
 * Student database using HashMap:
 * Create a class Student with fields name and gpa.
 * Create a HashMap that maps student IDs (strings) to Student objects.
 * Add 5 students to the HashMap using their IDs as keys.
 * Write a method to retrieve a Student by their ID and print their name and GPA.
 * @author eduglezexp
 * @version 1.0.0
 */

public class StudentMap {
    private String name;
    private String gpa;
    static Map<String,StudentMap> students;
    public StudentMap() {
        
    }
    public StudentMap(String name, String gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public String getGpa() {
        return gpa;
    }
    
    @Override
    public String toString() {
        return "StudentMap [name=" + name + ", gpa=" + gpa + "]";
    }
    public static void main(String[] args) {
        students = new HashMap<>();
        students.put("S101", new StudentMap("Alice", "3.8"));
        students.put("S102", new StudentMap("Bob", "3.5"));
        students.put("S103", new StudentMap("Charlie", "3.9"));
        students.put("S104", new StudentMap("Diana", "3.7"));
        students.put("S105", new StudentMap("Eve", "4.0"));
        String id = "S102";
        findStudentById(id);
    }

    public static void findStudentById(String id) {
        if (students.containsKey(id)) {
            System.out.println(students.get(id));
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}