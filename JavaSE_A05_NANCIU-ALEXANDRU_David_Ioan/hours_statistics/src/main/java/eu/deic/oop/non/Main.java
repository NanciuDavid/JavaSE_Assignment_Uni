package eu.deic.oop.non;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    final int weeks = 3; 
    final int days = 7;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int minutesPerDay[][] = new int [weeks][days];
    for(int i = 0 ; i < weeks ; i++) {
        for(int j = 0 ; j < days ; j++) {
            System.out.printf("\nGenerated number of minutes for week %d, day %d :", i+1, j+1);
            int numberOfMinutes = random.nextInt(540);
            minutesPerDay[i][j] = numberOfMinutes;
            System.out.println("\n");
            System.out.println(minutesPerDay[i][j]);
        }
    }

    int max = minutesPerDay[0][0];
    int min = minutesPerDay[0][0];

    int dayOfMax = 0, dayOfMin = 0, weekOnMax = 0, weekOnMin = 0 ;

    for(int i = 0 ; i < weeks ; i ++) {
        for(int j = 0 ; j < days ; j++) {
            if(minutesPerDay[i][j] >= max) {
                max = minutesPerDay[i][j];
                weekOnMax = i ;
                dayOfMax = j;
            } else if (minutesPerDay[i][j] <= min ) {
                min = minutesPerDay[i][j];
                dayOfMin = j;
                weekOnMin = i;
            } 
        }
    }
    
    System.out.printf("\nThe maximum number of minutes registered is : %d minutes, on week %d, day %d", max, ++weekOnMax, ++dayOfMax);
    System.out.printf("\nThe minimum number of hours registered is : %d minutes, on week %d, day %d", min, ++weekOnMin, ++dayOfMin);

    scanner.close();
    }
}
