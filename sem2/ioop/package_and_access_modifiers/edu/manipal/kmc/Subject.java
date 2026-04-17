/*Create Department, Course, and Subject classes demonstrating protected and public access modifiers.*/

package edu.manipal.kmc;

public class Subject {
    private String subjectName;
    private int subjectCredits;
    
    public void setSubjectDetails(String name, int credits) {
        subjectName = name;
        subjectCredits = credits;
    }
    
    public void displaySubject() {
        System.out.println("Subject: " + subjectName + ", Credits: " + subjectCredits);
    }
}
