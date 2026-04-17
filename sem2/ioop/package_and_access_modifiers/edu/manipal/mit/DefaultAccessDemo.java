/*Create a package edu.manipal.mit. Create a Student class with default access modifiers. Demonstrate that default access restricts access from different packages.*/

package edu.manipal.mit;

public class DefaultAccessDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Alice";
        s.rollNumber = 101;
        s.displayDetails();
    }
}
