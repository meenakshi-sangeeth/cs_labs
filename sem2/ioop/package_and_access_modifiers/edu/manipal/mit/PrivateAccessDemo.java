/*Update the Student class to mark attributes as private and provide public setter methods.*/

package edu.manipal.mit;

public class PrivateAccessDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Alice");
        s.setRollNumber(101);
        s.displayDetails();
        
        // s.name = "Bob";       // ERROR: private access
        // s.rollNumber = 102;   // ERROR: private access
    }
}
