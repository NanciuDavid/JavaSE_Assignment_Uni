package ro.ase.acs.classes;

import java.util.Arrays;

public class SummingMatrixThread extends Thread{

    private int startRow;
    private int endRow;
    private int[][] matrixOne;
    private int[][] matrixTwo;
    private int[][] resultMatrix;

    public SummingMatrixThread(int startRow, int endRow, int[][] matrixOne, int[][] matrixTwo, int[][] resultMatrix) {
        this.startRow = startRow;
        this.endRow = endRow;
        this.matrixOne = matrixOne;
        this.matrixTwo = matrixTwo;
        this.resultMatrix = resultMatrix;
    }

    public int[][] getSum() {
        return this.resultMatrix;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < Math.max(matrixOne.length, matrixTwo.length) ; i ++) {
            for(int j = 0 ; j < Math.max(matrixOne[0].length, matrixTwo[0].length) ; j++) {
                resultMatrix[i][j] = this.matrixOne[i][j] + this.matrixTwo[i][j];
            }
        }
    }


}



//impart nr de col si linii la nr de threaduri