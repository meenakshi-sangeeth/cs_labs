// Question: Write a Java program to compute the electricity bill for an industry
// using a switch-case statement. The program should take the daily consumption in
// units for 7 days as input. Based on the total consumption, calculate and display
// the total electricity bill according to the following pricing table:
// Units 0-100  : INR 7.00 per unit
// Units 101-200: INR 8.00 per unit
// Units >= 201 : INR 10.00 per unit

import java.util.Scanner;

class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int totalUnits = 0;
        System.out.println("Enter daily consumption for 7 days:");
        for(int i = 1; i <= 7; i++) {
            System.out.print("Day " + i + ": ");
            totalUnits += sc.nextInt();
        }
        
        double bill = 0;
        
        switch(totalUnits / 100) {
            case 0:
                bill = totalUnits * 7.0;
                break;
            case 1:
                bill = 100 * 7.0 + (totalUnits - 100) * 8.0;
                break;
            default:
                bill = 100 * 7.0 + 100 * 8.0 + (totalUnits - 200) * 10.0;
        }
        
        System.out.println("\nTotal units consumed: " + totalUnits);
        System.out.println("Total bill: INR " + bill);
    }
}
