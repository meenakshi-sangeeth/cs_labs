// Question: Write a Java program to display non diagonal elements and find their sum.
// [Hint: Non Principal diagonal: The diagonal of a diagonal matrix from the top right
// to the bottom left corner is called non principal diagonal.]

import java.util.Scanner;

class NonDiagonalElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter matrix size (n): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int sum = 0;
        System.out.println("Non-diagonal elements:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // Skip main diagonal (i==j) and anti-diagonal (i+j==n-1)
                if(i != j && i + j != n - 1) {
                    System.out.print(matrix[i][j] + " ");
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("\nSum of non-diagonal elements: " + sum);
    }
}
