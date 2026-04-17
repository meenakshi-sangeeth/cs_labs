/*Enhance the STUDENT class by adding an inner class named Subject that handles details of individual subjects. The inner class Subject should contain fields for subjectName and marks, provide methods to assign marks and display subject details. The STUDENT class should maintain an array of Subject objects, provide methods to add subjects, and calculate total and average marks.*/

import java.util.Scanner;

class Student {
    String sname;
    Subject[] subjects;
    int total;
    double avg;
    
    class Subject {
        String subjectName;
        int marks;
        
        void assignMarks(String name, int m) {
            subjectName = name;
            marks = m;
        }
        
        void displaySubject() {
            System.out.println(subjectName + ": " + marks);
        }
    }
    
    Student(String name, int numSubjects) {
        sname = name;
        subjects = new Subject[numSubjects];
    }
    
    void addSubjects() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < subjects.length; i++) {
            subjects[i] = new Subject();
            System.out.print("Enter subject name: ");
            String name = sc.next();
            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            subjects[i].assignMarks(name, marks);
        }
    }
    
    void compute() {
        total = 0;
        for(Subject sub : subjects) {
            total += sub.marks;
        }
        avg = (double) total / subjects.length;
    }
    
    void display() {
        System.out.println("\nStudent: " + sname);
        System.out.println("Subjects:");
        for(Subject sub : subjects) {
            sub.displaySubject();
        }
        System.out.println("Total: " + total + ", Average: " + avg);
    }
    
    public static void main(String[] args) {
        Student s = new Student("Alice", 3);
        s.addSubjects();
        s.compute();
        s.display();
    }
}
