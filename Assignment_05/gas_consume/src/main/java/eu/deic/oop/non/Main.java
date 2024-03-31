package eu.deic.oop.non;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ){
        int noOfDays ;
        int amountOfGas;
        Random random = new Random();
        float pricePerLitre = random.nextFloat(2);
        float overAllCost = .0f;
        float averageCost;

        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("Tracking the gas consume ( non - oop approach )");

        System.out.printf("Supposedly we have a price for the gas of :%.2f $ ", pricePerLitre);
        System.out.println("\nEnter the number of days to track");
        noOfDays = Integer.parseInt(scanner.nextLine());

        int days [] = new int[noOfDays];

        for(int i = 0 ; i < noOfDays ; i++) {
        System.out.printf("Enter the number of liters for day %d:  ", i+1);
        System.out.println();
        amountOfGas = Integer.parseInt(scanner.nextLine());
        days[i] = amountOfGas;
        }

        int overallConsume = 0 ;
        for(int i = 0 ; i < noOfDays ; i++) {
            overallConsume += days[i];
            overAllCost += days[i] * pricePerLitre;
        }

        System.out.printf("\nThe overall consume is : %d liters", overallConsume);
        System.out.printf("\nThe overall cost is : %.2f $", overAllCost);

        float averageConsume = .0f;
        averageConsume = overallConsume / noOfDays;

        averageCost = overAllCost / noOfDays;

        System.out.printf("\nThe average consume is : %.2f liters", averageConsume);
        System.out.printf("\nThe average cost is : %.2f $", averageCost);

    }

    
}
