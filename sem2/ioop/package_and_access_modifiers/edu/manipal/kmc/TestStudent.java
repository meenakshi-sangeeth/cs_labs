/*Create a package edu.manipal.mit. Create a Student class with default access modifiers. Demonstrate that default access restricts access from different packages.*/

package edu.manipal.kmc;
import edu.manipal.mit.Student;

public class TestStudent {
    public static void main(String[] args) {
        Student s = new Student();
        // s.name = "Bob";       // ERROR: not accessible from different package
        // s.rollNumber = 102;   // ERROR: not accessible from different package
        // Compilation error: name and rollNumber have default access
    }
}
