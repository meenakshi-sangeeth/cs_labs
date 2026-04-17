/*Write a program to manage course enrollment. If a course exceeds its capacity, throw a custom checked exception called CourseFullException.*/

import java.util.Scanner;

class CourseFullException extends Exception {
    CourseFullException(String message) {
        super(message);
    }
}

class Course {
    private String courseName;
    private int capacity;
    private int enrolledStudents;
    
    Course(String name, int cap) {
        courseName = name;
        capacity = cap;
        enrolledStudents = 0;
    }
    
    void enrollStudent() throws CourseFullException {
        if(enrolledStudents >= capacity) {
            throw new CourseFullException("Course " + courseName + " is full!");
        }
        enrolledStudents++;
        System.out.println("Student enrolled successfully. Total enrolled: " + enrolledStudents);
    }
    
    void display() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrolled: " + enrolledStudents + "/" + capacity);
    }
}

class CourseCapacityDemo {
    public static void main(String[] args) {
        Course c = new Course("Java Programming", 3);
        
        try {
            c.enrollStudent();
            c.enrollStudent();
            c.enrollStudent();
            c.enrollStudent();
        } catch(CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        c.display();
    }
}
