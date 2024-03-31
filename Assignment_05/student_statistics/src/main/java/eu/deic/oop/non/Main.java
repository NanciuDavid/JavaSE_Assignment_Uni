package eu.deic.oop.non;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter the number of students:");
        final int numberOfStudents = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of assignments:");
        final int numberOfAssignments = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of classes:");
        final int numberOfClasses = Integer.parseInt(scanner.nextLine());

        float[] averageMarkPerClass = new float[numberOfClasses];

        int index = 0;
        while (index < numberOfClasses) {
            float averageMarkPerClassCurrent = 0;

            for (int i = 0; i < numberOfStudents; i++) {
                float sum = 0;
                for (int j = 0; j < numberOfAssignments; j++) {
                    int grade = random.nextInt(11); // Generate a grade between 0 and 10
                    sum += grade;
                }
                float averageGrade = sum / numberOfAssignments;
                System.out.printf("\nThe average grade for student %d in Class %d is %.2f\n", i + 1, index + 1, averageGrade);
                averageMarkPerClassCurrent += averageGrade;
            }

            averageMarkPerClass[index] = averageMarkPerClassCurrent / numberOfStudents;
            index++;
        }

        for (int i = 0; i < numberOfClasses; i++) {
            System.out.printf("\nThe average for the class %d is %.2f ", i + 1, averageMarkPerClass[i]);
        }

        scanner.close();
    }
}
