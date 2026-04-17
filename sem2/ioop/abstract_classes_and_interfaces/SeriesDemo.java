/*Design an interface called Series with methods getNext(), reset(), and setStart(). Design a class named ByTwos that implements Series such that it generates a series of numbers, each two greater than the previous one.*/

interface Series {
    int getNext();
    void reset();
    void setStart(int x);
}

class ByTwos implements Series {
    int start;
    int current;
    
    ByTwos() {
        start = 0;
        current = 0;
    }
    
    public int getNext() {
        current += 2;
        return current;
    }
    
    public void reset() {
        current = start;
    }
    
    public void setStart(int x) {
        start = x;
        current = x;
    }
}

class SeriesDemo {
    public static void main(String[] args) {
        ByTwos bt = new ByTwos();
        
        bt.setStart(10);
        
        System.out.println("Series starting from 10:");
        for(int i = 0; i < 5; i++) {
            System.out.println(bt.getNext());
        }
        
        bt.reset();
        System.out.println("\nAfter reset: " + bt.getNext());
    }
}
