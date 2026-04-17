/*To the already defined Employee class, add the following string processing methods: formatEmployeeName() to format the employee's name by capitalizing the first letter of each word, generateEmail() to generate an email address based on their name.*/

import java.util.Scanner;

class Employee {
    String Ename;
    int Eid;
    double salary;
    
    Employee(String name, int id, double sal) {
        Ename = name;
        Eid = id;
        salary = sal;
    }
    
    void formatEmployeeName() {
        String[] words = Ename.toLowerCase().split(" ");
        Ename = "";
        for(String word : words) {
            Ename += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
        }
        Ename = Ename.trim();
    }
    
    String generateEmail() {
        String[] parts = Ename.toLowerCase().split(" ");
        String email = parts[0].charAt(0) + parts[parts.length - 1] + "@example.com";
        return email;
    }
    
    void display() {
        System.out.println("Name: " + Ename);
        System.out.println("Email: " + generateEmail());
        System.out.println("ID: " + Eid + ", Salary: " + salary);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        Employee[] emp = new Employee[n];
        for(int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i+1) + ":");
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter salary: ");
            double sal = sc.nextDouble();
            sc.nextLine();
            
            emp[i] = new Employee(name, id, sal);
            emp[i].formatEmployeeName();
        }
        
        System.out.println("\n--- Employee Details ---");
        for(Employee e : emp) {
            e.display();
            System.out.println();
        }
    }
}
