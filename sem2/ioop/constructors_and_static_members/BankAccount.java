/*
Define a class to represent a Bank account. Include the following members. 
Data members: 
    a. Name of the depositor 
    b. Account number. 
    c. Type of account. 
    d. Balance amount in the account. 
    e. Rate of interest (static data) 
Provide a default constructor and parameterized constructor to this class. 
Also provide Methods: 
    a. To deposit amount. 
    b. To withdraw amount after checking for minimum balance. 
    c. To display all the details of an account holder. 
    d. Display rate of interest (a static method) 
Illustrate all the constructors as well as all the methods by defining objects.
*/

class BankAccount {
    String depositorName;
    int accountNumber;
    String accountType;
    double balance;
    static double rateOfInterest = 5.5;
    
    // Default constructor
    BankAccount() {
        depositorName = "Unknown";
        accountNumber = 0;
        accountType = "Savings";
        balance = 0;
    }
    
    // Parameterized constructor
    BankAccount(String name, int accNo, String type, double bal) {
        depositorName = name;
        accountNumber = accNo;
        accountType = type;
        balance = bal;
    }
    
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    void withdraw(double amount) {
        if(balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance! Minimum balance of 1000 required.");
        }
    }
    
    void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + depositorName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
    
    static void showRateOfInterest() {
        System.out.println("Rate of Interest: " + rateOfInterest + "%");
    }
    
    public static void main(String[] args) {
        BankAccount.showRateOfInterest();
        
        BankAccount acc1 = new BankAccount("John Doe", 12345, "Savings", 5000);
        acc1.display();
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.display();
    }
}
