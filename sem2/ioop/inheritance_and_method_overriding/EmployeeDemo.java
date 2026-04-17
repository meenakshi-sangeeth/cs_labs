/*To the already defined EMPLOYEE class, add two subclasses FullTimeEmp and PartTimeEmp. FullTimeEmp should add bonus and deductions. PartTimeEmp should add hoursWorked and hourlyRate.*/

class Employee {
    String eName;
    int eId;
    double basic, DA, grossSal, netSal;
    
    Employee(String name, int id, double b) {
        eName = name;
        eId = id;
        basic = b;
    }
    
    void calculateSalary() {
        DA = 0.52 * basic;
        grossSal = basic + DA;
        netSal = grossSal - (0.30 * grossSal);
    }
    
    void displayEmployeeDetails() {
        System.out.println("Name: " + eName + ", ID: " + eId);
        System.out.println("Net Salary: " + netSal);
    }
}

class FullTimeEmp extends Employee {
    double bonus, deductions;
    
    FullTimeEmp(String name, int id, double b, double bon, double ded) {
        super(name, id, b);
        bonus = bon;
        deductions = ded;
    }
    
    void calculateSalary() {
        super.calculateSalary();
        netSal = netSal + bonus - deductions;
    }
    
    void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Bonus: " + bonus + ", Deductions: " + deductions);
    }
}

class PartTimeEmp extends Employee {
    int hoursWorked;
    static final double hourlyRate = 100;
    
    PartTimeEmp(String name, int id, int hours) {
        super(name, id, 0);
        hoursWorked = hours;
    }
    
    void calculateSalary() {
        netSal = hoursWorked * hourlyRate;
    }
    
    void displayEmployeeDetails() {
        System.out.println("Name: " + eName + ", ID: " + eId);
        System.out.println("Hours: " + hoursWorked + ", Rate: " + hourlyRate);
        System.out.println("Net Salary: " + netSal);
    }
}

class EmployeeDemo {
    public static void main(String[] args) {
        System.out.println("--- Full Time Employee ---");
        FullTimeEmp f = new FullTimeEmp("Alice", 101, 50000, 5000, 2000);
        f.calculateSalary();
        f.displayEmployeeDetails();
        
        System.out.println("\n--- Part Time Employee ---");
        PartTimeEmp p = new PartTimeEmp("Bob", 102, 80);
        p.calculateSalary();
        p.displayEmployeeDetails();
    }
}
