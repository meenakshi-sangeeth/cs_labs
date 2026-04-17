// Write a Java program to rotate the elements of an array to the right/left
// by a given number of steps. The program should handle arrays of different sizes and
// should be able to rotate the array in both directions (left and right).

import java.util.Scanner;

class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter rotation steps: ");
        int steps = sc.nextInt();
        System.out.print("Direction (L/R): ");
        char dir = sc.next().charAt(0);
        
        steps = steps % n;
        
        if(dir == 'R' || dir == 'r') {
            rotateRight(arr, steps);
        } else {
            rotateLeft(arr, steps);
        }
        
        System.out.println("Rotated array:");
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
    
    static void rotateRight(int[] arr, int steps) {
        int n = arr.length;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, steps - 1);
        reverse(arr, steps, n - 1);
    }
    
    static void rotateLeft(int[] arr, int steps) {
        int n = arr.length;
        reverse(arr, 0, steps - 1);
        reverse(arr, steps, n - 1);
        reverse(arr, 0, n - 1);
    }
    
    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
