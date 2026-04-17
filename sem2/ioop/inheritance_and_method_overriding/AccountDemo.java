/*Create an Account class with subclasses SavingsAccount and CurrentAccount. Include methods to deposit, withdraw, display balance, and compute interest.*/

import java.util.Scanner;

class Account {
    String customerName;
    int accNo;
    String accountType;
    double balance;
    
    Account(String name, int acc, String type, double bal) {
        customerName = name;
        accNo = acc;
        accountType = type;
        balance = bal;
    }
    
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    static final double interestRate = 4.5;
    
    SavingsAccount(String name, int acc, double bal) {
        super(name, acc, "Savings", bal);
    }
    
    void computeInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
    
    void withdraw(double amount) {
        if(balance - amount >= 500) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Minimum balance of 500 required!");
        }
    }
}

class CurrentAccount extends Account {
    static final double minBalance = 1000;
    static final double serviceTax = 50;
    
    CurrentAccount(String name, int acc, double bal) {
        super(name, acc, "Current", bal);
    }
    
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        if(balance < minBalance) {
            balance -= serviceTax;
            System.out.println("Service tax imposed: " + serviceTax);
        }
    }
}

class AccountDemo {
    public static void main(String[] args) {
        System.out.println("--- Savings Account ---");
        SavingsAccount sa = new SavingsAccount("Alice", 1001, 5000);
        sa.deposit(2000);
        sa.computeInterest();
        sa.withdraw(1000);
        sa.displayBalance();
        
        System.out.println("\n--- Current Account ---");
        CurrentAccount ca = new CurrentAccount("Bob", 2001, 3000);
        ca.deposit(1000);
        ca.withdraw(3500);
        ca.displayBalance();
    }
}
