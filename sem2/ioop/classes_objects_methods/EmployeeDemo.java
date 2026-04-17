/*
Define a class EMPLOYEE having following members: Ename, Eid, Basic, DA, 
Gross_Sal, Net_Sal and following methods: 
a. read(): to read N employee details 
b. display(): to display employee details 
c. compute_net_sal(): to compute net salary 
Write a Java program to read data of N employee and compute and display net salary 
of each employee Note: (DA = 52% of Basic, gross_Sal = Basic + DA; IT = 30% of 
the gross salary) 
*/

import java.util.Scanner;

class Employee {
    String Ename;
    int Eid;
    double Basic, DA, Gross_Sal, Net_Sal;
    
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        Ename = sc.next();
        System.out.print("Enter ID: ");
        Eid = sc.nextInt();
        System.out.print("Enter basic salary: ");
        Basic = sc.nextDouble();
    }
    
    void compute_net_sal() {
        DA = 0.52 * Basic;
        Gross_Sal = Basic + DA;
        double IT = 0.30 * Gross_Sal;
        Net_Sal = Gross_Sal - IT;
    }
    
    void display() {
        System.out.println("\nEmployee Details");
        System.out.println("Name: " + Ename);
        System.out.println("ID: " + Eid);
        System.out.println("Basic: " + Basic);
        System.out.println("DA: " + DA);
        System.out.println("Gross Salary: " + Gross_Sal);
        System.out.println("Net Salary: " + Net_Sal);
    }
}

class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];
        
        for(int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i+1) + ":");
            emp[i] = new Employee();
            emp[i].read();
            emp[i].compute_net_sal();
        }
        
        for(int i = 0; i < n; i++) {
            emp[i].display();
        }
    }
}
