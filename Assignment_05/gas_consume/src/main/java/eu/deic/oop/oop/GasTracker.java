package eu.deic.oop.oop;

import java.util.Scanner;



public class GasTracker {
    private float pricePerLitre;
    private int[] days;

    public GasTracker(float pricePerLitre) {
        this.pricePerLitre = pricePerLitre;
    }

    public void trackGasConsumption(int noOfDays) {
        Scanner scanner = new Scanner(System.in);
        days = new int[noOfDays];

        for (int i = 0; i < noOfDays; i++) {
            System.out.printf("Enter the number of liters for day %d: ", i + 1);
            System.out.println();
            int amountOfGas = Integer.parseInt(scanner.nextLine());
            days[i] = amountOfGas;
        }
    }

    public int calculateOverallConsumption() {
        int overallConsume = 0;
        for (int day : days) {
            overallConsume += day;
        }
        return overallConsume;
    }

    public float calculateOverallCost() {
        float overAllCost = 0;
        for (int day : days) {
            overAllCost += day * pricePerLitre;
        }
        return overAllCost;
    }

    public float calculateAverageConsumption() {
        int overallConsumption = calculateOverallConsumption();
        return (float) overallConsumption / days.length;
    }

    public float calculateAverageCost() {
        float overallCost = calculateOverallCost();
        return overallCost / days.length;
    }

}