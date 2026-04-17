// Write a Java program to add two numbers using the bitwise operator and
// check if the output is an even or odd number.
// [Hint: use left shift and right shift bitwise operators]

import java.util.Scanner;

class BitwiseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        System.out.println("Sum: " + a);
        if(a % 2 == 0)
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
