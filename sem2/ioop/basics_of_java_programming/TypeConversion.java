// Write a Java program to execute the following statements.
// Observe and analyze the outputs.
// a. int x = 10; double y = x; System.out.println(y);
// b. double x = 10.5; int y = x; System.out.println(y);
// c. double x = 10.5; int y = (int) x; System.out.println(y);

class TypeConversion {
    public static void main(String[] args) {
        // Case a: Widening conversion (int to double)
        int x1 = 10;
        double y1 = x1;
        System.out.println("Case a: " + y1); // Output: 10.0
        
        // Case b: Narrowing conversion (compile error)
        double x2 = 10.5;
        // int y2 = x2; // Compilation error - incompatible types
        System.out.println("Case b: Compilation error - incompatible types");
        
        // Case c: Explicit casting
        double x3 = 10.5;
        int y3 = (int) x3;
        System.out.println("Case c: " + y3); // Output: 10 (truncated)
    }
}
