package eu.deic.oop;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Matrix matrix = new Matrix(3, 3);
        matrix.setValues(matrix);
        System.out.println("The matrix generated with the parameter constructor :");
        System.out.println(matrix);

        
        Matrix matrix2 = new Matrix();
        matrix2.setValues(matrix2);
        
        System.out.println();
        System.out.println(matrix2);

        
    }
}
