/*Create an abstract class Figure with an abstract method area and two integer variables that represent x and y dimensions. Create three more classes Rectangle, Triangle and Square that extend Figure and implement the area method appropriately. Illustrate dynamic polymorphism.*/

abstract class Figure {
    int x, y;
    
    Figure(int a, int b) {
        x = a;
        y = b;
    }
    
    abstract double area();
}

class Rectangle extends Figure {
    Rectangle(int a, int b) {
        super(a, b);
    }
    
    double area() {
        return x * y;
    }
}

class Triangle extends Figure {
    Triangle(int a, int b) {
        super(a, b);
    }
    
    double area() {
        return 0.5 * x * y;
    }
}

class Square extends Figure {
    Square(int a) {
        super(a, a);
    }
    
    double area() {
        return x * x;
    }
}

class FigureDemo {
    public static void main(String[] args) {
        Figure f;
        
        f = new Rectangle(10, 5);
        System.out.println("Rectangle area: " + f.area());
        
        f = new Triangle(10, 8);
        System.out.println("Triangle area: " + f.area());
        
        f = new Square(7);
        System.out.println("Square area: " + f.area());
    }
}
