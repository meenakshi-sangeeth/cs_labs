/*Create Department, Course, and Subject classes demonstrating protected and public access modifiers.*/

package edu.manipal.mit;

public class Department {
    protected String departmentName;
    public String departmentCode;
    
    public void setDepartmentDetails(String name, String code) {
        departmentName = name;
        departmentCode = code;
    }
    
    public void displayDepartment() {
        System.out.println("Department: " + departmentName + " (" + departmentCode + ")");
    }
}
