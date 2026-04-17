// Write a Java program to accept the number of hours worked, hourly rate and
// calculates the salary for an employee according to the following criteria:
// The company pays straight time for the first 40 hours worked by each employee
// and time and a half for all hours worked in excess of 40 hours.

import java.util.Scanner;

class SalaryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter hours worked: ");
        int hours = sc.nextInt();
        System.out.print("Enter hourly rate: ");
        double rate = sc.nextDouble();
        
        double salary;
        if(hours <= 40) {
            salary = hours * rate;
        } else {
            salary = (40 * rate) + ((hours - 40) * rate * 1.5);
        }
        
        System.out.println("Total salary: " + salary);
    }
}
