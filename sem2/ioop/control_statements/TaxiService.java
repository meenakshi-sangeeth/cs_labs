// Question: A Taxi service offers a new service based on travel distance.
// Write a Java program to calculate the total distance traveled by considering
// the following charges:
// First 5 km  = INR 10/km
// Next 15 km  = INR 8/km
// Next 25 km  = INR 5/km

import java.util.Scanner;

class TaxiService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter distance in km: ");
        double distance = sc.nextDouble();
        double charge = 0;
        
        if(distance <= 5) {
            charge = distance * 10;
        } else if(distance <= 20) {
            charge = 5 * 10 + (distance - 5) * 8;
        } else {
            charge = 5 * 10 + 15 * 8 + (distance - 20) * 5;
        }
        
        System.out.println("Total charge: INR " + charge);
    }
}
