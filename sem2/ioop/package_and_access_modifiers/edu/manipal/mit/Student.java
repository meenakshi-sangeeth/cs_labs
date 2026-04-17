/*Update the Student class to mark attributes as private and provide public setter methods.*/

package edu.manipal.mit;

public class Student {
    private String name;
    private int rollNumber;
    
    public void setName(String n) {
        name = n;
    }
    
    public void setRollNumber(int r) {
        rollNumber = r;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name + ", Roll: " + rollNumber);
    }
}
