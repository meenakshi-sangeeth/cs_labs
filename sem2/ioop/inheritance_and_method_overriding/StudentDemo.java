/*To the already defined STUDENT class, add two subclasses ScienceStudent and ArtsStudent. ScienceStudent should add practicalMarks and override compute() to include practical marks. ArtsStudent should add an electiveSubject field.*/

import java.util.Scanner;

class Student {
    String sname;
    int[] marks;
    int total;
    double avg;
    
    Student(String name, int[] m) {
        sname = name;
        marks = m;
    }
    
    void compute() {
        total = 0;
        for(int mark : marks) {
            total += mark;
        }
        avg = (double) total / marks.length;
    }
    
    void display() {
        System.out.println("Name: " + sname);
        System.out.println("Total: " + total + ", Average: " + avg);
    }
}

class ScienceStudent extends Student {
    int practicalMarks;
    
    ScienceStudent(String name, int[] m, int practical) {
        super(name, m);
        practicalMarks = practical;
    }
    
    void compute() {
        super.compute();
        total += practicalMarks;
        avg = (double) total / (marks.length + 1);
    }
    
    void displayPracticalMarks() {
        System.out.println("Practical Marks: " + practicalMarks);
    }
    
    void display() {
        super.display();
        displayPracticalMarks();
    }
}

class ArtsStudent extends Student {
    String electiveSubject;
    
    ArtsStudent(String name, int[] m, String elective) {
        super(name, m);
        electiveSubject = elective;
    }
    
    void display() {
        super.display();
        System.out.println("Elective: " + electiveSubject);
    }
}

class StudentDemo {
    public static void main(String[] args) {
        System.out.println("--- Regular Student ---");
        Student s1 = new Student("Alice", new int[]{80, 85, 90});
        s1.compute();
        s1.display();
        
        System.out.println("\n--- Science Student ---");
        ScienceStudent s2 = new ScienceStudent("Bob", new int[]{75, 80}, 88);
        s2.compute();
        s2.display();
        
        System.out.println("\n--- Arts Student ---");
        ArtsStudent s3 = new ArtsStudent("Charlie", new int[]{85, 90, 78}, "Psychology");
        s3.compute();
        s3.display();
        
        System.out.println("\n--- Dynamic Polymorphism ---");
        Student s = new ScienceStudent("David", new int[]{70, 75}, 85);
        s.compute();
        s.display();
    }
}
