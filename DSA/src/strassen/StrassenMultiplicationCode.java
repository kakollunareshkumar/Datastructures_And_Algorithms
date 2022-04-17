package strassen;
import java.util.Scanner;

public class StrassenMultiplicationCode {

    // Read user input from console by using scanner class and make it static to access all over the program
    private static Scanner sc = new Scanner(System.in);

    // Strassen Algorithm to compute product of two matrices
    public int[][] multiply(int[][] c, int[][] d) {

        // Length of a matrix
        int n = c.length;

        // Final matrix to store computed result
        int[][] e = new int[n][n];

        if (n == 1)
            e[0][0] = c[0][0] * d[0][0];
        else {
            int[][] C11 = new int[n / 2][n / 2];
            int[][] C12 = new int[n / 2][n / 2];
            int[][] C21 = new int[n / 2][n / 2];
            int[][] C22 = new int[n / 2][n / 2];
            int[][] D11 = new int[n / 2][n / 2];
            int[][] D12 = new int[n / 2][n / 2];
            int[][] D21 = new int[n / 2][n / 2];
            int[][] D22 = new int[n / 2][n / 2];

            // divide matrix c into sub matrices
            split(c, C11, 0, 0);
            split(c, C12, 0, n / 2);
            split(c, C21, n / 2, 0);
            split(c, C22, n / 2, n / 2);
            // divide matrix B into sub matrices
            split(d, D11, 0, 0);
            split(d, D12, 0, n / 2);
            split(d, D21, n / 2, 0);
            split(d, D22, n / 2, n / 2);

            /**
             * Q1 = (C11 + C22)(D11 + D22)
             * Q2 = (C21 + C22) D11
             * Q3 = C11 (D12 - D22)
             * Q4 = C22 (D21 - D11)
             * Q5 = (C11 + C12) D22
             * Q6 = (C21 - C11) (D11 + D12)
             * Q7 = (C12 - C22) (D21 + D22)
             **/

            int[][] p1 = multiply(add(C11, C22), add(D11, D22));
            int[][] p2 = multiply(add(C21, C22), D11);
            int[][] p3 = multiply(C11, sub(D12, D22));
            int[][] p4 = multiply(C22, sub(D21, D11));
            int[][] p5 = multiply(add(C11, C12), D22);
            int[][] p6 = multiply(sub(C21, C11), add(D11, D12));
            int[][] p7 = multiply(sub(C12, C22), add(D21, D22));

            /**
             * E11 = p1 + p4 - p5 + p7
             * E12 = p3 + p5
             * E21 = p2 + p4
             * E22 = p1 - p2 + p3 + p6
             **/

            int[][] E11 = add(sub(add(p1, p4), p5), p7);
            int[][] E12 = add(p3, p5);
            int[][] E21 = add(p2, p4);
            int[][] E22 = add(sub(add(p1, p3), p2), p6);

            // join 4 halves into one result matrix
            join(E11, e, 0, 0);
            join(E12, e, 0, n / 2);
            join(E21, e, n / 2, 0);
            join(E22, e, n / 2, n / 2);
        }

        // return resultant matrix
        return e;
    }

    // method to add two matrices
    public int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = a[i][j] + b[i][j];
        return c;
    }

    //subtract two matrices
    public int[][] sub(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = a[i][j] - b[i][j];
        return c;
    }

    // split matrices
    public void split(int[][] p, int[][] c,
                      int fromIndex, int toIndex) {
        for (int i1=0, i2=fromIndex; i1 < c.length; i1++, i2++)
            for (int j1=0, j2=toIndex; j1 < c.length; j1++, j2++)
                c[i1][j1] = p[i2][j2];
    }

    // join two matrices
    public void join(int[][] c, int[][] p,
                     int start, int end) {
        for (int i1=0, i2=start; i1 < c.length; i1++, i2++)
            for (int j1=0, j2=end; j1 < c.length; j1++, j2++)
                p[i2][j2] = c[i1][j1];
    }

    // read matrix input elements and return final matrix
    public int[][] readMatrix(int[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                // read input element one by one
                temp[i][j] = sc.nextInt();
            }
        }
        return temp;
    }

    // main method
    public static void main(String[] args) {

        System.out.println(" "+
                "computation of two matrices by strassen algorithm\n");

        // Create an object of Matrix class
        StrassenMultiplicationCode m = new StrassenMultiplicationCode();

        // define and initialize variables with null
        int size = 0;
        int c[][] = null; // first matrix
        int d[][] = null; // second matrix
        int e[][] = null; // Final matrix contains product of c and d matrices

        System.out.print(" Please enter the size of the matrix ");
        size = sc.nextInt();

        // initialize matrices
        c = new int[size][size];
        d = new int[size][size];
        e = new int[size][size];

        // read matrix c and d
        System.out.println("Enter Matrix c: ");
        c = m.readMatrix(c);
        System.out.println("Enter Matrix d: ");
        d = m.readMatrix(d);

        // multiplication of matrix c and d and store result in e matrix
        e = m.multiply(c, d);

        // display resultant matrix
        System.out.println("display final e matrix result");
        for(int i=0; i<e.length; i++) {
            for(int j=0; j<e[0].length; j++) {
                System.out.print(e[i][j]+" ");
            }
            System.out.println(); //Empty line to give some space in output
        }
    }
}