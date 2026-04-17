/*Write a program to calculate the average marks of a student. If the number of subjects is zero, throw an ArithmeticException to avoid division by zero.*/

import java.util.Scanner;

class Student {
    double calculateAverage(int totalMarks, int numberOfSubjects) throws ArithmeticException {
        if(numberOfSubjects == 0) {
            throw new ArithmeticException("Number of subjects cannot be zero!");
        }
        return (double) totalMarks / numberOfSubjects;
    }
}

class MarksValidationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        
        try {
            System.out.print("Enter total marks: ");
            int total = sc.nextInt();
            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            
            double avg = s.calculateAverage(total, subjects);
            System.out.println("Average marks: " + avg);
        } catch(ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\nTesting with valid data:");
        try {
            double avg2 = s.calculateAverage(450, 5);
            System.out.println("Average marks: " + avg2);
        } catch(ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
