package matrix;

public class Matrix {


    int[][] multiplyMatrix(int[][] a, int[][] b) {
        int c[][] = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(c[i][j] + " ");  //printing matrix element
            }
            System.out.println();//new line

        }
        return c;
    }


    public static void main(String[] args) {

        int a[][] = {{1, 9, 2}, {2, 5, 6}, {7, 4, 5}};
        int b[][] = {{2, 6, 2}, {5, 8, 9}, {3, 5, 7}};
        Matrix m = new Matrix();
        m.multiplyMatrix(a, b);

    }
}
