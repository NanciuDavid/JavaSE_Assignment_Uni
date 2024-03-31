package eu.deic.oop.non;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        final int parkingSpaces;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of places : ");
        parkingSpaces = Integer.parseInt(scanner.nextLine());

        int parkingSpaceMinutes[][] = new int[parkingSpaces][5];
        int maxTimeSpent[] = new int[parkingSpaces];
        int minTimeSpent[] = new int[parkingSpaces];

        for (int i = 0; i < parkingSpaces; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            System.out.println("\n------------------------------");
            for (int j = 0; j < 5; j++) {
                System.out.printf("\nEnter the number of minutes for parking lot %d, day %d : ", i + 1, j + 1);
                parkingSpaceMinutes[i][j] = Integer.parseInt(scanner.nextLine());

                if (parkingSpaceMinutes[i][j] > max) {
                    max = parkingSpaceMinutes[i][j];
                }
                if (parkingSpaceMinutes[i][j] < min) {
                    min = parkingSpaceMinutes[i][j];
                }
            }

            maxTimeSpent[i] = max;
            minTimeSpent[i] = min;
        }

        for (int i = 0; i < parkingSpaces; i++) {
            System.out.println("\n##########################################");
            System.out.printf("\nThe maximum time spent for parking space %d is : %d ", i + 1, maxTimeSpent[i]);
            System.out.printf("\nThe minimum time spent for parking space %d is : %d ", i + 1, minTimeSpent[i]);
            System.out.println("\n");
        }

        scanner.close();
    }
}
