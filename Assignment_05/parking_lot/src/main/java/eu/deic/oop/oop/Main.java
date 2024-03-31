package eu.deic.oop.oop;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        final int parkingSpaces;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of places : ");
        parkingSpaces = Integer.parseInt(scanner.nextLine());

        Parking[] parkingLots = new Parking[parkingSpaces];

        for (int i = 0; i < parkingSpaces; i++) {
            parkingLots[i] = new Parking(5);

            System.out.println("\n------------------------------");
            for (int j = 0; j < 5; j++) {
                System.out.printf("\nEnter the number of minutes for parking lot %d, day %d : ", i + 1, j + 1);
                int minutes = Integer.parseInt(scanner.nextLine());
                parkingLots[i].setMinutes(j, minutes);
            }
        }

        for (int i = 0; i < parkingSpaces; i++) {
            System.out.println("\n##########################################");
            System.out.printf("\nThe maximum time spent for parking space %d is : %d ", i + 1, parkingLots[i].getMaxMinutes());
            System.out.printf("\nThe minimum time spent for parking space %d is : %d ", i + 1, parkingLots[i].getMinMinutes());
            System.out.println("\n");
        }

        scanner.close();
    }
}