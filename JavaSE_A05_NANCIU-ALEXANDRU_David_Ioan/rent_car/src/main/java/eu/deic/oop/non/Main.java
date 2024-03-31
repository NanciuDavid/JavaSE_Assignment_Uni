package eu.deic.oop.non;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of cars: ");
        int numCars = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of days: ");
        int numDays = Integer.parseInt(scanner.nextLine());

        double[][] distance = new double[numCars][numDays];

        for (int car = 0; car < numCars; car++) {
            System.out.println("\nCar " + (car + 1) + " Kilometers:");
            for (int day = 0; day < numDays; day++) {
                System.out.print("Day " + (day + 1) + ": ");
                distance[car][day] = scanner.nextDouble();
            }
        }

        double[] avgPerCar = new double[numCars];
        double[] maxDistances = new double[numCars];
        double[] minDistances = new double[numCars];

        for (int car = 0; car < numCars; car++) {
            double total = 0;
            maxDistances[car] = Double.MIN_VALUE;
            minDistances[car] = Double.MAX_VALUE;

            for (int day = 0; day < numDays; day++) {
                total += distance[car][day];
                maxDistances[car] = Math.max(maxDistances[car], distance[car][day]);
                minDistances[car] = Math.min(minDistances[car], distance[car][day]);
            }

            avgPerCar[car] = total / numDays;
        }

        // Print
        System.out.println("\n----------------------------------------------------");

        System.out.println("\nAverage Kilometers per Day for Each Car:");
        for (int car = 0; car < numCars; car++) {
            System.out.println("Car " + (car + 1) + ": " + Math.floor(avgPerCar[car] * 100) / 100.00);
        }

        System.out.println("\nMaximum kilometers per Day for Each Car:");
        for (int car = 0; car < numCars; car++) {
            System.out.println("Car " + (car + 1) + ": " + Math.floor(maxDistances[car] * 100) / 100.00);
        }

        System.out.println("\nMinimum kilometers per Day for Each Car:");
        for (int car = 0; car < numCars; car++) {
            System.out.println("Car " + (car + 1) + ": " + Math.floor(minDistances[car] * 100) / 100.00);
        }
    }
}
