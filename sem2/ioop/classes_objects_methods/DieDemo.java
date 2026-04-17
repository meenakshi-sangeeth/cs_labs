/*
 * LAB 3 - Exercise 4: Die Class
 *
 * Create a Die class with one integer instance variable called sideUp.
 * Give it a getSideUp() method that returns the value of sideUp and a
 * void roll() method that changes sideUp to a random value from 1 to 6.
 * Then create a DieDemo class with a method that creates two Die objects,
 * rolls them, and prints the sum of the two sides up.
 */

import java.util.Random;

class Die {
    private int sideUp;
    private Random random;
    
    Die() {
        random = new Random();
        roll();
    }
    
    int getSideUp() {
        return sideUp;
    }
    
    void roll() {
        sideUp = random.nextInt(6) + 1;
    }
}

class DieDemo {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();
        
        System.out.println("Rolling the dice...");
        die1.roll();
        die2.roll();
        
        System.out.println("Die 1: " + die1.getSideUp());
        System.out.println("Die 2: " + die2.getSideUp());
        System.out.println("Sum: " + (die1.getSideUp() + die2.getSideUp()));
    }
}
