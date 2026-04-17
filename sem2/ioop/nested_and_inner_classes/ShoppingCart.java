/*Implement a ShoppingCart class that contains an inner class Item. The Item class should have fields like itemName, quantity, and price. The ShoppingCart class should provide methods to add items, calculate the total price, and display the cart contents.*/

import java.util.Scanner;
import java.util.ArrayList;

class ShoppingCart {
    ArrayList<Item> items;
    
    class Item {
        String itemName;
        int quantity;
        double price;
        
        Item(String name, int qty, double p) {
            itemName = name;
            quantity = qty;
            price = p;
        }
        
        double getTotal() {
            return quantity * price;
        }
    }
    
    ShoppingCart() {
        items = new ArrayList<>();
    }
    
    void addItem(String name, int qty, double price) {
        items.add(new Item(name, qty, price));
        System.out.println("Added: " + name);
    }
    
    double calculateTotal() {
        double total = 0;
        for(Item item : items) {
            total += item.getTotal();
        }
        return total;
    }
    
    void displayCart() {
        System.out.println("\nShopping Cart");
        for(Item item : items) {
            System.out.println(item.itemName + " x" + item.quantity + 
                             " @ " + item.price + " = " + item.getTotal());
        }
        System.out.println("Total: " + calculateTotal());
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 5, 20);
        cart.addItem("Book", 2, 150);
        cart.addItem("Pen", 10, 10);
        cart.displayCart();
    }
}
