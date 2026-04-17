// Question: For a given date of birth of a person, calculate the date of retirement
// by taking years of service as input. (assume service period as 60 years)

import java.util.Scanner;

class RetirementDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter birth year: ");
        int birthYear = sc.nextInt();
        System.out.print("Enter years of service: ");
        int service = sc.nextInt();
        
        int retirementYear = birthYear + service;
        System.out.println("Retirement year: " + retirementYear);
    }
}
