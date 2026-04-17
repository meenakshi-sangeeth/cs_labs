/*Create InvalidSalaryException and ContractLimitExceededException custom exceptions for employee validation.*/

class InvalidSalaryException extends Exception {
    InvalidSalaryException(String message) {
        super(message);
    }
}

class ContractLimitExceededException extends Exception {
    ContractLimitExceededException(String message) {
        super(message);
    }
}

class Employee {
    String name;
    double salary;
    
    Employee(String name) {
        this.name = name;
    }
    
    void setSalary(double salary) throws InvalidSalaryException {
        if(salary < 50000) {
            throw new InvalidSalaryException("Salary cannot be less than minimum wage (50,000)");
        }
        this.salary = salary;
    }
    
    void display() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }
}

class ContractEmployee extends Employee {
    int contractDuration;
    
    ContractEmployee(String name) {
        super(name);
    }
    
    void setContractDuration(int months) throws ContractLimitExceededException {
        if(months > 24) {
            throw new ContractLimitExceededException("Contract duration cannot exceed 24 months");
        }
        contractDuration = months;
    }
    
    void display() {
        super.display();
        System.out.println("Contract Duration: " + contractDuration + " months");
    }
}

class EmployeeExceptionDemo {
    public static void main(String[] args) {
        try {
            Employee e = new Employee("John");
            e.setSalary(60000);
            e.display();
            
            System.out.println();
            
            ContractEmployee ce = new ContractEmployee("Alice");
            ce.setSalary(55000);
            ce.setContractDuration(18);
            ce.display();
            
            System.out.println("\nTrying invalid salary...");
            Employee e2 = new Employee("Bob");
            e2.setSalary(40000);
            
        } catch(InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(ContractLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        try {
            System.out.println("\nTrying invalid contract duration...");
            ContractEmployee ce2 = new ContractEmployee("Charlie");
            ce2.setSalary(50000);
            ce2.setContractDuration(30);
            
        } catch(InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(ContractLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
