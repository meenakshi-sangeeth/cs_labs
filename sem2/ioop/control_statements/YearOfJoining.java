// Question: For a given 9-digit registration number of a CSE student, identify the
// year of joining. Assuming the first two digits specify the year of joining.

import java.util.Scanner;

class YearOfJoining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter 9-digit registration number: ");
        String regNo = sc.next();
        
        if(regNo.length() == 9) {
            String year = "20" + regNo.substring(0, 2);
            System.out.println("Year of joining: " + year);
        } else {
            System.out.println("Invalid registration number");
        }
    }
}
