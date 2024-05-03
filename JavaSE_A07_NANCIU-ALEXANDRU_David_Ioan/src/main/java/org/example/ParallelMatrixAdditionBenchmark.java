package org.example;

import ro.ase.acs.classes.SummingMatrixThread;

import java.io.*;
import java.util.Random;

public class ParallelMatrixAdditionBenchmark {

    private static final int ROWS = 10000;
    private static final int COLUMNS = 10000;
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        int[][] matrixOne = readMatrixFromFile("MatriceUnu.txt", ROWS, COLUMNS);
        int[][] matrixTwo = readMatrixFromFile("MatriceDoi.txt", ROWS, COLUMNS);

        // Now you have both matrices read from files, you can proceed with your operations

        System.out.println("\n!!!!!!======================THIS INCLUDES ALSO TASK 7.4 ================================!!!!!\n");

        benchmarkParallelRowAddition(matrixOne, matrixTwo, 1);
        benchmarkParallelRowAddition(matrixOne, matrixTwo, 2);
        benchmarkParallelRowAddition(matrixOne, matrixTwo, 4);
        benchmarkParallelRowAddition(matrixOne, matrixTwo, 8);

        benchmarkParallelMatrixAddition(matrixOne, matrixTwo, 1);
        benchmarkParallelMatrixAddition(matrixOne, matrixTwo, 2);
        benchmarkParallelMatrixAddition(matrixOne, matrixTwo, 4);
        benchmarkParallelMatrixAddition(matrixOne, matrixTwo, 8);



    }

    public static int[][] readMatrixFromFile(String fileName, int rows, int columns) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            generateMatrixToFile(fileName, rows, columns);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int[][] matrix = new int[rows][columns];
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < rows) {
                String[] values = line.trim().split("\\s+");
                for (int col = 0; col < Math.min(values.length, columns); col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
            return matrix;
        }
    }

    public static void generateMatrixToFile(String fileName, int rows, int columns) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int value = random.nextInt(100);
                    bw.write(String.valueOf(value)); // Convert int to String
                    bw.write(" ");
                }
                bw.write("\n");
            }
        }
    }

    public static int[][] parallelAdditionMatrix(int[][] matrixOne, int[][] matrixTwo, int numThreads) {
        int[][] resultMatrix = new int[ROWS][COLUMNS];

        int rowsSegmentThreadSize = ROWS / numThreads;
        int columnsSegmentThreadSize = COLUMNS / numThreads;

        // Create and start threads
        SummingMatrixThread[] threads = new SummingMatrixThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int startRow = i * rowsSegmentThreadSize;
            int endRow = (i == numThreads - 1) ? ROWS : (i + 1) * rowsSegmentThreadSize;
            threads[i] = new SummingMatrixThread(startRow, endRow, matrixOne, matrixTwo, resultMatrix);
            threads[i].start();
        }

        // Wait for threads to finish
        try {
            for (SummingMatrixThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultMatrix;
    }

    public static void benchmarkParallelMatrixAddition(int[][] matrixOne, int[][] matrixTwo, int numThreads) {
        long startTime = System.currentTimeMillis();

        int[][] resultedMatrix = parallelAdditionMatrix(matrixOne, matrixTwo, numThreads);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Parallel addition with " + numThreads + " threads: " + executionTime + " ms");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ResultedMatrix.txt"))) {
            for (int[] row : resultedMatrix) {
                for (int value : row) {
                    bw.write(String.valueOf(value));
                    bw.write(" ");
                }
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The resulted matrix was written into : ResultedMatrix.txt");
    }


    public static void benchmarkParallelRowAddition(int[][] matrixOne, int[][] matrixTwo, int numThreads) {
        long startTime = System.currentTimeMillis();

        int[][] resultedMatrix = parallelAdditionMatrix(matrixOne, matrixTwo, numThreads);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Parallel row addition with " + numThreads + " threads: " + executionTime + " ms");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("RowAdditionResults.txt"))) {
            for (int[] row : resultedMatrix) {
                int sum = 0;
                for (int value : row) {
                    sum += value;
                }
                bw.write(String.valueOf(sum));
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
