package eu.deic.oop.oop;

import java.util.Scanner;

class Car {
    private double[] distances;

    public Car(int numDays, Scanner scanner) {
        distances = new double[numDays];
        for (int day = 0; day < numDays; day++) {
            System.out.print("Enter kilometers for day " + (day + 1) + ": ");
            distances[day] = scanner.nextDouble();
        }
    }

    public double getAverageDistance() {
        double total = 0;
        for (double distance : distances) {
            total += distance;
        }
        return total / distances.length;
    }

    public double getMaxDistance() {
        double max = Double.MIN_VALUE;
        for (double distance : distances) {
            max = Math.max(max, distance);
        }
        return max;
    }

    public double getMinDistance() {
        double min = Double.MAX_VALUE;
        for (double distance : distances) {
            min = Math.min(min, distance);
        }
        return min;
    }
}