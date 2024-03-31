package eu.deic.oop;
import java.util.Random;
import java.util.Scanner;

public class Matrix implements generateValues {

    //attributes : lines , columns ; 

    private int lines ;
    private int columns;
    private int matrix[][];
    private Random random = new Random();

    public Matrix(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        this.matrix = new int[lines][columns];
    }
    
    public Matrix() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of lines: ");
    this.lines = scanner.nextInt();
    System.out.println("Enter the number of columns: ");
    this.columns = scanner.nextInt();
    this.matrix = new int[lines][columns];

    }
    

    public void setLines(int lines) {
        this.lines = lines;
    }

    public void setColumns(int columns) {
        this.columns = columns;

    }

    public int getLines() {
        return this.lines;
    }

    public int getColumns() { 
        return this.columns;
    }

    @Override
    public void setValues(Matrix obj) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the range of the elements : ");
    int range = Integer.parseInt(scanner.nextLine());
    for(int i = 0 ; i < obj.lines ; i++) {
        for(int j = 0 ; j < obj.columns; j++)
            obj.matrix[i][j] = random.nextInt(range);
    }


    }
        

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n The matrix was generated randomly with the values:\n");
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lines;
        result = prime * result + columns;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                result = prime * result + matrix[i][j];
            }
        }
        return result;
    }
    
}
