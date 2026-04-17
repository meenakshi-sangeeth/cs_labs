/*Create Department, Course, and Subject classes demonstrating protected and public access modifiers.*/

package edu.manipal.mit;

public class Course extends Department {
    private String courseName;
    private int courseDuration;
    
    public void setCourseDetails(String name, int duration) {
        courseName = name;
        courseDuration = duration;
    }
    
    public void displayCourse() {
        displayDepartment();
        System.out.println("Course: " + courseName + ", Duration: " + courseDuration + " years");
    }
}
