/*
Define a class Mixer to merge two sorted integer arrays in ascending order with 
the following instance variables and methods: 
- instance variables
    int arr[] : to store the elements of an array 
- methods
    void accept() - to accept the elements of the array in ascending order without any duplicates 
    Mixer mix(Mixer A) - to merge the current object array elements with the parameterized array elements and return the resultant object 
    void display() - to display the elements of the array Define the main() method to test the class. 
*/

import java.util.Scanner;

class Mixer {
    int[] arr;
    
    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter sorted array elements (no duplicates):");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
    
    Mixer mix(Mixer A) {
        Mixer result = new Mixer();
        result.arr = new int[this.arr.length + A.arr.length];
        
        int i = 0, j = 0, k = 0;
        
        // Merge while removing duplicates
        while(i < this.arr.length && j < A.arr.length) {
            if(this.arr[i] < A.arr[j]) {
                result.arr[k++] = this.arr[i++];
            } else if(this.arr[i] > A.arr[j]) {
                result.arr[k++] = A.arr[j++];
            } else {
                result.arr[k++] = this.arr[i++];
                j++;
            }
        }
        
        while(i < this.arr.length) {
            result.arr[k++] = this.arr[i++];
        }
        
        while(j < A.arr.length) {
            result.arr[k++] = A.arr[j++];
        }
        
        // Trim array to actual size
        int[] temp = new int[k];
        for(int x = 0; x < k; x++) {
            temp[x] = result.arr[x];
        }
        result.arr = temp;
        
        return result;
    }
    
    void display() {
        System.out.print("Array: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Mixer m1 = new Mixer();
        Mixer m2 = new Mixer();
        
        System.out.println("First array:");
        m1.accept();
        
        System.out.println("\nSecond array:");
        m2.accept();
        
        Mixer m3 = m1.mix(m2);
        
        System.out.println("\nMerged array:");
        m3.display();
    }
}
