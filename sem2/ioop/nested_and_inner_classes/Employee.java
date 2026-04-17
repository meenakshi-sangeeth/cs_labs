/*Implement an EMPLOYEE class with an inner class named Department that handles department-related details. The inner class Department should contain fields for departmentName and location. The EMPLOYEE class should contain fields for eName, salary, and an array of Department objects.*/

import java.util.Scanner;

class Employee {
    String eName;
    double salary;
    Department[] departments;
    
    class Department {
        String departmentName;
        String location;
        
        void setDetails(String name, String loc) {
            departmentName = name;
            location = loc;
        }
        
        void displayDepartment() {
            System.out.println("  Department: " + departmentName + ", Location: " + location);
        }
    }
    
    Employee(String name, double sal, int numDepts) {
        eName = name;
        salary = sal;
        departments = new Department[numDepts];
    }
    
    void addDepartments() {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < departments.length; i++) {
            departments[i] = new Department();
            System.out.print("Enter department name: ");
            String name = sc.next();
            System.out.print("Enter location: ");
            String loc = sc.next();
            departments[i].setDetails(name, loc);
        }
    }
    
    void display() {
        System.out.println("\nEmployee: " + eName);
        System.out.println("Salary: " + salary);
        System.out.println("Departments:");
        for(Department dept : departments) {
            dept.displayDepartment();
        }
    }
    
    public static void main(String[] args) {
        Employee e = new Employee("Bob Smith", 50000, 2);
        e.addDepartments();
        e.display();
    }
}
