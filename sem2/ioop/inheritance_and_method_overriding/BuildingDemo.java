/*Create a Building class with two subclasses namely, House and School. All the classes contain appropriate overloaded constructors and methods to display the details.*/

class Building {
    double squareFootage;
    int stories;
    
    Building() {
        squareFootage = 0;
        stories = 0;
    }
    
    Building(double sqft, int st) {
        squareFootage = sqft;
        stories = st;
    }
    
    void display() {
        System.out.println("Square Footage: " + squareFootage);
        System.out.println("Stories: " + stories);
    }
}

class House extends Building {
    int bedrooms;
    int baths;
    
    House() {
        super();
        bedrooms = 0;
        baths = 0;
    }
    
    House(double sqft, int st, int bed, int bath) {
        super(sqft, st);
        bedrooms = bed;
        baths = bath;
    }
    
    void display() {
        System.out.println("--- House ---");
        super.display();
        System.out.println("Bedrooms: " + bedrooms);
        System.out.println("Bathrooms: " + baths);
    }
}

class School extends Building {
    int classrooms;
    String gradeLevel;
    
    School() {
        super();
        classrooms = 0;
        gradeLevel = "Unknown";
    }
    
    School(double sqft, int st, int rooms, String grade) {
        super(sqft, st);
        classrooms = rooms;
        gradeLevel = grade;
    }
    
    void display() {
        System.out.println("--- School ---");
        super.display();
        System.out.println("Classrooms: " + classrooms);
        System.out.println("Grade Level: " + gradeLevel);
    }
}

class BuildingDemo {
    public static void main(String[] args) {
        House h = new House(2500, 2, 4, 3);
        h.display();
        
        System.out.println();
        
        School s = new School(10000, 3, 30, "Elementary");
        s.display();
    }
}
