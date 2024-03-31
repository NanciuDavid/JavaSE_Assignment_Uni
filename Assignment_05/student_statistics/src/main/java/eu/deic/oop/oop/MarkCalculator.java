package eu.deic.oop.oop;

import java.util.Random;
import java.util.Scanner;

public class MarkCalculator {
    private int numberOfClasses;
    private int numberOfStudents;
    private int numberOfAssignments;
    private double[][] marksArray;

    public MarkCalculator(int numberOfClasses, int numberOfStudents, int numberOfAssignments) {
        this.numberOfClasses = numberOfClasses;
        this.numberOfStudents = numberOfStudents;
        this.numberOfAssignments = numberOfAssignments;
        marksArray = new double[numberOfClasses * numberOfStudents][numberOfAssignments];
        generateRandomMarks();
    }

    private void generateRandomMarks() {
        Random random = new Random();
        for (int i = 0; i < marksArray.length; i++) {
            for (int j = 0; j < marksArray[i].length; j++) {
                marksArray[i][j] = random.nextDouble() * 100; // Generate a random mark between 0 and 100
            }
        }
    }

    public void addMarks(Scanner scanner) {
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.printf("\nEnter marks for class %d%n", classIndex + 1);
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                System.out.printf("\nFor Student %d%n", studentIndex + 1);
                for (int assignmentIndex = 0; assignmentIndex < numberOfAssignments; assignmentIndex++) {
                    System.out.printf("Enter mark for assignment %d: ", assignmentIndex + 1);
                    marksArray[classIndex * numberOfStudents + studentIndex][assignmentIndex] = scanner.nextDouble();
                }
            }
        }
    }

    public double[][] calculateStudentAverages() {
        double[][] averagePerStudentArray = new double[numberOfClasses][numberOfStudents];

        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                double studentTotalMarks = 0;
                for (int assignmentIndex = 0; assignmentIndex < numberOfAssignments; assignmentIndex++) {
                    studentTotalMarks += marksArray[classIndex * numberOfStudents + studentIndex][assignmentIndex];
                }
                averagePerStudentArray[classIndex][studentIndex] = studentTotalMarks / numberOfAssignments;
            }
        }

        return averagePerStudentArray;
    }

    public double[] calculateClassAverages() {
        double[] averagePerClassArray = new double[numberOfClasses];

        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            double classTotalMarks = 0;
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                for (int assignmentIndex = 0; assignmentIndex < numberOfAssignments; assignmentIndex++) {
                    classTotalMarks += marksArray[classIndex * numberOfStudents + studentIndex][assignmentIndex];
                }
            }
            averagePerClassArray[classIndex] = classTotalMarks / (numberOfStudents * numberOfAssignments);
        }

        return averagePerClassArray;
    }

    public double calculateTotalAverage() {
        double totalAverageForEntireYear = 0;
        double[] classAverages = calculateClassAverages();

        for (int i = 0; i < numberOfClasses; i++) {
            totalAverageForEntireYear += classAverages[i];
        }
        totalAverageForEntireYear /= numberOfClasses;

        return totalAverageForEntireYear;
    }

    public void printMarks() {
        System.out.println("\nAverage Mark for Each Student:");
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.printf("%nClass %d:%n", classIndex + 1);
            double[][] studentAverages = calculateStudentAverages();
            for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
                System.out.printf("Student %d: %.2f%n", studentIndex + 1, studentAverages[classIndex][studentIndex]);
            }
        }

        System.out.println("\nAverage Mark for Each Class:");
        double[] classAverages = calculateClassAverages();
        for (int classIndex = 0; classIndex < numberOfClasses; classIndex++) {
            System.out.printf("Class %d: %.2f%n", classIndex + 1, classAverages[classIndex]);
        }

        System.out.printf("%nTotal Average for the Entire Year: %.2f%n", calculateTotalAverage()/12);
    }
}
