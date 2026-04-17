/*Write a menu driven program to do the following: Check whether a string is palindrome or not, Write the string in an alphabetical order, Reverse the string, Concatenate the original string and the reversed string.*/

import java.util.Scanner;
import java.util.Arrays;

class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        while(true) {
            System.out.println("\n--- String Operations Menu ---");
            System.out.println("1. Check Palindrome");
            System.out.println("2. Alphabetical Order");
            System.out.println("3. Reverse");
            System.out.println("4. Concatenate with Reverse");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    String rev = new StringBuilder(str).reverse().toString();
                    if(str.equalsIgnoreCase(rev))
                        System.out.println("Palindrome");
                    else
                        System.out.println("Not Palindrome");
                    break;
                case 2:
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    System.out.println("Sorted: " + new String(chars));
                    break;
                case 3:
                    System.out.println("Reversed: " + new StringBuilder(str).reverse());
                    break;
                case 4:
                    String reversed = new StringBuilder(str).reverse().toString();
                    System.out.println("Concatenated: " + str + reversed);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
