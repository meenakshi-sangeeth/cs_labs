/*
Define a class to represent a Bank account. Include the following members. 
    a. Name of the depositor 
    b. Account number. 
    c. Type of account. 
    d. Balance amount in the account. 
    e. Rate of interest (static data) 
*/

class Student {
    String sname;
    int[] marks;
    int total;
    double avg;
    
    Student() {
        sname = "Unknown";
        marks = new int[3];
        total = 0;
        avg = 0.0;
    }
    
    Student(String name, int[] m) {
        sname = name;
        marks = m;
        compute();
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
        System.out.print("Marks: ");
        for(int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nTotal: " + total + ", Average: " + avg);
    }
    
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("Student created with default constructor:");
        s1.display();
        
        System.out.println();
        
        int[] marks = {85, 90, 78};
        Student s2 = new Student("Percy", marks);
        System.out.println("Student created with parameterized constructor:");
        s2.display();
    }
}
