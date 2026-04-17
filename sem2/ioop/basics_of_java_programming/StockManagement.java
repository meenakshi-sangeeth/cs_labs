// Write a Java program to manage stock information for multiple products.
// The program should store the product name, product price, and quantity in separate
// one-dimensional arrays for n items. The user should be able to specify which products
// they want to purchase and the desired quantity for each. Based on the user's input,
// the program should generate and display the total bill.

import java.util.Scanner;

class StockManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        
        String[] names = new String[n];
        double[] prices = new double[n];
        int[] quantities = new int[n];
        
        System.out.println("Enter product details:");
        for(int i = 0; i < n; i++) {
            System.out.print("Product name: ");
            names[i] = sc.next();
            System.out.print("Price: ");
            prices[i] = sc.nextDouble();
            System.out.print("Quantity available: ");
            quantities[i] = sc.nextInt();
        }
        
        double totalBill = 0;
        System.out.println("\nEnter purchases (enter -1 to stop):");
        while(true) {
            System.out.print("Product index (0 to " + (n-1) + "): ");
            int idx = sc.nextInt();
            if(idx == -1) break;
            
            System.out.print("Quantity to buy: ");
            int qty = sc.nextInt();
            
            if(idx >= 0 && idx < n && qty <= quantities[idx]) {
                totalBill += prices[idx] * qty;
                quantities[idx] -= qty;
                System.out.println("Added to cart!");
            } else {
                System.out.println("Invalid purchase!");
            }
        }
        
        System.out.println("\nTotal Bill: " + totalBill);
    }
}
