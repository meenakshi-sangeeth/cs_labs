/*Write a program to validate the age of a student during their registration. If the age is not between 18 and 60, throw an IllegalArgumentException.*/

import java.util.Scanner;

class Student {
    private String name;
    private int age;
    
    void registerStudent(String name, int age) throws IllegalArgumentException {
        if(age < 18 || age > 60) {
            throw new IllegalArgumentException("Age must be between 18 and 60");
        }
        this.name = name;
        this.age = age;
        System.out.println("Student registered successfully: " + name);
    }
    
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class StudentAgeValidationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            
            s.registerStudent(name, age);
            s.display();
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
