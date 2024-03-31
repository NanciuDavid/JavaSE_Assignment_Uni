package eu.deic.oop.oop;

import java.util.Random;
import java.util.Scanner;

public class Main{
        public static void main(String[] args) {

        Random random = new Random();
        float pricePerLitre = random.nextFloat() * 2; // Generate a random price between 0 and 2

        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("Tracking the gas consume (OOP approach)");

        System.out.printf("Supposedly we have a price for the gas of: %.2f $%n", pricePerLitre);
        System.out.println("Enter the number of days to track:");
        int noOfDays = Integer.parseInt(scanner.nextLine());

        GasTracker gasTracker = new GasTracker(pricePerLitre);
        gasTracker.trackGasConsumption(noOfDays);

        int overallConsume = gasTracker.calculateOverallConsumption();
        float overAllCost = gasTracker.calculateOverallCost();
        float averageConsume = gasTracker.calculateAverageConsumption();
        float averageCost = gasTracker.calculateAverageCost();

        System.out.printf("%nThe overall consume is: %d liters%n", overallConsume);
        System.out.printf("The overall cost is: %.2f $%n", overAllCost);
        System.out.printf("The average consume is: %.2f liters%n", averageConsume);
        System.out.printf("The average cost is: %.2f $%n", averageCost);
    }
}
