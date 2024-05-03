package ro.ase.acs.classes;

public class DotProductThread extends Thread {

    private int[] arrayOne;
    private int[] arrayTwo;

    private int startIndex;
    private int endIndex;
    private int[] product; // Initialize product array

    public DotProductThread(int[] arrayOne, int[] arrayTwo, int startIndex, int endIndex) {
        this.arrayOne = arrayOne;
        this.arrayTwo = arrayTwo;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.product = new int[arrayOne.length]; // Initialize product array with the length of arrayOne
    }

    public int[] getDotProduct() {
        return this.product;
    }

    public void run() {
        for (int i = startIndex; i < endIndex; i++) { // Iterate from startIndex to endIndex
            product[i] = arrayOne[i] * arrayTwo[i];
        }
    }
}
