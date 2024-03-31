package eu.deic.oop.oop;

import java.util.Scanner;

public class UserInterface  {

        private Scanner scanner;

        public UserInterface() {
            this.scanner = new Scanner(System.in);
        }

        public void start() {

        System.out.print("\nEnter the number of cars: ");
        int numCars = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of days: ");
        int numDays = Integer.parseInt(scanner.nextLine());

        Car[] cars = new Car[numCars];

        for (int i = 0; i < numCars; i++) {
            System.out.println("\nCar " + (i + 1) + ":");
            cars[i] = new Car(numDays, scanner);
        }

        // Print
        System.out.println("\n----------------------------------------------------");

        System.out.println("\nAverage Kilometers per Day for Each Car:");
        for (int i = 0; i < numCars; i++) {
            System.out.println("Car " + (i + 1) + ": " + Math.floor(cars[i].getAverageDistance() * 100) / 100.00);
        }

        System.out.println("\nMaximum kilometers per Day for Each Car:");
        for (int i = 0; i < numCars; i++) {
            System.out.println("Car " + (i + 1) + ": " + Math.floor(cars[i].getMaxDistance() * 100) / 100.00);
        }

        System.out.println("\nMinimum kilometers per Day for Each Car:");
        for (int i = 0; i < numCars; i++) {
            System.out.println("Car " + (i + 1) + ": " + Math.floor(cars[i].getMinDistance() * 100) / 100.00);
        }

        scanner.close();
    }
}