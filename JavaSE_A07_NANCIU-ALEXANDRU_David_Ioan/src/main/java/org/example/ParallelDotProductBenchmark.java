package org.example;

import ro.ase.acs.classes.DotProductThread;
import ro.ase.acs.classes.SummingThread;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ParallelDotProductBenchmark {

    private static final int SIZE = 4_000_000;

    public static void main(String[] args) {
        ParallelDotProductBenchmark benchmark = new ParallelDotProductBenchmark();
        benchmark.execute();
    }


    public void execute() {

        int[] vector1 = generateRandomVector(SIZE);
        int[] vector2 = generateRandomVector(SIZE);

        benchmarkParallelDotProduct(vector1, vector2, 1);
        benchmarkParallelDotProduct(vector1, vector2, 2);
        benchmarkParallelDotProduct(vector1, vector2, 4);
        benchmarkParallelDotProduct(vector1, vector2, 8);

    }

    private static void benchmarkParallelDotProduct(int[] vector1, int[] vector2, int numThreads) {
        long startTime = System.currentTimeMillis();

        int[] results = parallelDotProduct(vector1, vector2, numThreads);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Parallel dot product with " + numThreads + " threads: " + executionTime + " ms");
        if (Integer.valueOf(results[0]) == 0) {
            System.out.println("Product was not computed");
        } else {
            System.out.println("Product was computed ! Do you want to print it ? 1 if so, otherwise press 0");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.valueOf(scanner.nextLine());
            if (choice == 1) {
                System.out.println(Arrays.toString(results));
            } else {
                return;
            }
        }

    }


    private static int[] generateRandomVector(int size) {
        int[] vector = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            vector[i] = random.nextInt(100);
        }
        return vector;
    }


    private static int[] parallelDotProduct(int[] vector1, int[] vector2, int numThreads) {
        DotProductThread[] threads = new DotProductThread[numThreads];
        int segmentSize = vector1.length / numThreads;
        int[] product = new int[vector1.length];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * segmentSize;
            int endIndex = (i == numThreads - 1) ? vector1.length : (i + 1) * segmentSize;

            threads[i] = new DotProductThread(vector1, vector2, startIndex, endIndex);
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                int[] partialResult = threads[i].getDotProduct();
                for (int j = 0; j < partialResult.length; j++) {
                    product[j] += partialResult[j];
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

}
