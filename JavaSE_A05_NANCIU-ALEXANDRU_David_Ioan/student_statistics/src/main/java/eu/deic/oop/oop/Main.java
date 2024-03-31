package eu.deic.oop.oop;

public class Main {
    public static void main(String args[]){
        MarkCalculator markcalculator = new MarkCalculator(5, 5,5 );
        System.out.println(markcalculator);
        markcalculator.printMarks();
    }
}
