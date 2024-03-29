package eu.deic.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
    

    public static void main( String[] args )
    {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] array = new int[100];

        int boundary = setBoundary(scanner) ;


        try {
            for(int i = 0 ; i < 100; i ++) {
            array[i] = random.nextInt(boundary);
        }   
        } catch (Exception e) {
            System.out.println("\nBoundary must be > 0");
            return;
        } 
        
        System.out.println();
        showArray(array);

        double average = computeAverage(array);

        howManyAboveAverage(array, average);


    }

    public static void showArray(int array[]) {
        System.out.println("==============================================================");
        System.out.println("--------------------Elements of the array--------------------");
        System.out.println();

        for(int i = 0 ; i < array.length; i++) {
            if(i == 20 || i == 40 || i == 60 || i == 80) {
                System.out.println();
            }
            System.out.printf("%4d", array[i]);
            
        }
        System.out.println();
        
    }


    public static double computeAverage(int array[]) {
        double average = 0.0;
        for(int i = 0 ; i < array.length ; i++) {
            average+=array[i];
        }

        return average/array.length;
    }

    public static int setBoundary(Scanner scanner) {
        System.out.print("Select the boundary of generated values : ");
        int input = 0;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("\nInput must be integer type");
        }
        return input;
    }


    public static void howManyAboveAverage(int array[], double average) {
        int counter = 0 ;
        for(int i = 0 ; i < array.length ; i++) {
            if(array[i] > average) {
                counter ++ ;
            }
        }   
    
    System.out.println();
    System.out.printf("==============The average of the array is: %.2f==============", average);
    System.out.println();
    System.out.printf("------------There are %d numbers above the average------------", counter);
    System.out.println();
    }
}
