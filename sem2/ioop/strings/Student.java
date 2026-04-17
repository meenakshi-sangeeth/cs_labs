/*To the already defined Student class, add the following methods: extractInitials() to extract initials from the student's name, removeWhitespace() to remove any whitespace characters from the student's name, list all student names containing a particular substring, and sort the students alphabetically.*/

import java.util.Scanner;
import java.util.Arrays;

class Student {
    String sname;
    int[] marks;
    
    Student(String name, int[] m) {
        sname = name;
        marks = m;
    }
    
    String extractInitials() {
        String[] words = sname.split(" ");
        String initials = "";
        for(String word : words) {
            initials += word.charAt(0);
        }
        return initials.toUpperCase();
    }
    
    String removeWhitespace() {
        return sname.replaceAll("\\s", "");
    }
    
    void display() {
        System.out.println("Name: " + sname);
        System.out.println("Initials: " + extractInitials());
        System.out.println("No spaces: " + removeWhitespace());
    }
    
    static void findBySubstring(Student[] students, String substring) {
        System.out.println("\nStudents with '" + substring + "' in their name:");
        for(Student s : students) {
            if(s.sname.toLowerCase().contains(substring.toLowerCase())) {
                System.out.println(s.sname);
            }
        }
    }
    
    static void sortAlphabetically(Student[] students) {
        Arrays.sort(students, (a, b) -> a.sname.compareTo(b.sname));
    }
    
    public static void main(String[] args) {
        Student[] students = {
            new Student("Percy", new int[]{80, 90}),
            new Student("Annabeth", new int[]{85, 88}),
            new Student("Grover", new int[]{75, 82}),
            new Student("Luke", new int[]{90, 92})
        };
        
        System.out.println("Student Details");
        for(Student s : students) {
            s.display();
            System.out.println();
        }
        
        findBySubstring(students, "ov");
        
        sortAlphabetically(students);
        System.out.println("\nSorted Alphabetically ");
        for(Student s : students) {
            System.out.println(s.sname);
        }
    }
}
