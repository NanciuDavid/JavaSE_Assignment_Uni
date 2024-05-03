package org.example;

import ro.ase.acs.classes.SummingThread;

import java.util.Random;

public class ParallelVectorAdditionBenchmark {

    private static final int SIZEONE = 10_000_000;
    private static final int SIZETWO = 20_000_000;

    public static void main(String[] args) {
        ParallelVectorAdditionBenchmark benchmark = new ParallelVectorAdditionBenchmark();
        benchmark.execute();
    }

    public void execute() {
        int[] vector1 = generateRandomVector(SIZEONE);
        int[] vector2 = generateRandomVector(SIZETWO);

        benchmarkParallelAddition(vector1, vector2, 1);
        benchmarkParallelAddition(vector1, vector2, 2);
        benchmarkParallelAddition(vector1, vector2, 4);
    }

    private static void benchmarkParallelAddition(int[] vector1, int[] vector2, int numThreads) {
        long startTime = System.currentTimeMillis();

        int[] results = parallelAddition(vector1, vector2, numThreads);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Parallel addition with " + numThreads + " threads: " + executionTime + " ms");
        System.out.println("Result: " + results[0] + " + " + results[1] + " = " + (results[0] + results[1]));
    }

    private static int[] generateRandomVector(int size) {
        int[] vector = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            vector[i] = random.nextInt(100);
        }
        return vector;
    }

    private static int[] parallelAddition(int[] vector1, int[] vector2, int numThreads) {
        int[] sum = new int[2];
        int segmentSize1 = vector1.length / numThreads;
        int segmentSize2 = vector2.length / numThreads;

        SummingThread[] threadsForArrayOne = new SummingThread[numThreads];
        SummingThread[] threadsForArrayTwo = new SummingThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIdx1 = i * segmentSize1;
            int endIdx1 = (i == numThreads - 1) ? vector1.length : (i + 1) * segmentSize1;
            threadsForArrayOne[i] = new SummingThread(startIdx1, endIdx1, vector1);
            threadsForArrayOne[i].start();

            int startIdx2 = i * segmentSize2;
            int endIdx2 = (i == numThreads - 1) ? vector2.length : (i + 1) * segmentSize2;
            threadsForArrayTwo[i] = new SummingThread(startIdx2, endIdx2, vector2);
            threadsForArrayTwo[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threadsForArrayOne[i].join();
                threadsForArrayTwo[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum[0] += threadsForArrayOne[i].getSum();
            sum[1] += threadsForArrayTwo[i].getSum();
        }

        return sum;
    }
}
