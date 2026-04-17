/*Create Department, Course, and Subject classes demonstrating protected and public access modifiers.*/

package edu.manipal.kmc;
import edu.manipal.mit.*;

public class ProtectedAndPublicDemo {
    public static void main(String[] args) {
        Course c = new Course();
        c.setDepartmentDetails("Computer Science", "CSE");
        c.setCourseDetails("B.Tech", 4);
        c.displayCourse();
        
        // c.departmentName = "IT";  // ERROR: protected, not accessible
        c.departmentCode = "IT";     // OK: public
        
        Subject s = new Subject();
        s.setSubjectDetails("OOP", 3);
        s.displaySubject();
        
        // s.subjectName = "Java";   // ERROR: private
    }
}
