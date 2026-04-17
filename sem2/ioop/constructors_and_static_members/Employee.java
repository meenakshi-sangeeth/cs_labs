/*
 * LAB 4 - Exercise 2: EMPLOYEE Class with Constructors
 *
 * Consider the already defined EMPLOYEE class. Provide a default constructor
 * and parameterized constructor to this class. Also provide a display method.
 * Illustrate all the constructors as well as the display method by defining
 * EMPLOYEE objects.
 */

class Employee {
    String Ename;
    int Eid;
    double Basic, DA, Gross_Sal, Net_Sal;
    
    // Default constructor
    Employee() {
        Ename = "Unknown";
        Eid = 0;
        Basic = 0;
    }
    
    // Parameterized constructor
    Employee(String name, int id, double basic) {
        Ename = name;
        Eid = id;
        Basic = basic;
        compute();
    }
    
    void compute() {
        DA = 0.52 * Basic;
        Gross_Sal = Basic + DA;
        Net_Sal = Gross_Sal - (0.30 * Gross_Sal);
    }
    
    void display() {
        System.out.println("Name: " + Ename + ", ID: " + Eid);
        System.out.println("Basic: " + Basic);
        System.out.println("Net Salary: " + Net_Sal);
    }
    
    public static void main(String[] args) {
        // Using default constructor
        Employee e1 = new Employee();
        System.out.println("Employee created with default constructor:");
        e1.display();
        
        System.out.println();
        
        // Using parameterized constructor
        Employee e2 = new Employee("Alice Smith", 101, 50000);
        System.out.println("Employee created with parameterized constructor:");
        e2.display();
    }
}
