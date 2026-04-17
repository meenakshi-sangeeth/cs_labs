/*Design a class Student with methods getRollNum(), putRollNum(), getMarks() and putMarks(). Create an interface Sports with a method putSportsScore(). Design a class Result that implements this interface to generate the result by considering both marks and sports score.*/

import java.util.Scanner;

class Student {
    int rollNum;
    int[] marks;
    
    void getRollNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        rollNum = sc.nextInt();
    }
    
    void putRollNum() {
        System.out.println("Roll Number: " + rollNum);
    }
    
    void getMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        marks = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i+1) + ": ");
            marks[i] = sc.nextInt();
        }
    }
    
    void putMarks() {
        System.out.print("Marks: ");
        for(int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}

interface Sports {
    void putSportsScore(int score);
}

class Result extends Student implements Sports {
    int sportsScore;
    
    public void putSportsScore(int score) {
        sportsScore = score;
    }
    
    void displayResult() {
        putRollNum();
        putMarks();
        System.out.println("Sports Score: " + sportsScore);
        
        int total = sportsScore;
        for(int mark : marks) {
            total += mark;
        }
        System.out.println("Total: " + total);
    }
    
    public static void main(String[] args) {
        Result r = new Result();
        r.getRollNum();
        r.getMarks();
        r.putSportsScore(85);
        r.displayResult();
    }
}
