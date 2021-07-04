package matrix;

public class MatrixTraversal {


    private void printMatrix(int mat[][], int m, int n, int i, int j, int path[], int idx) {
        path[idx] = mat[i][j];

        // Reached the bottom of the matrix so we are left with
        // only option to move right
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            for (int l = 0; l < path.length; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }

        // Reached the right corner of the matrix we are left with
        // only the downward movement.
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
            }
            for (int l = 0; l < path.length; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }
        // Print all the paths that are possible after moving down
        printMatrix(mat, m, n, i + 1, j, path, idx + 1);

        // Print all the paths that are possible after moving right
        printMatrix(mat, m, n, i, j + 1, path, idx + 1);
    }


    private void print(int mat[][], int m, int n, int i, int j, int path[], int idx) {

        int column = 0;
        int n1 = mat[0].length;
        if (i == n) {
            return;
        }
        for (int k = 0; k < mat.length; k++) {
            path[idx++] = mat[k][i];
        }
        for (int k = 1; k < n1 - i; k++) {
            path[idx++] = mat[mat.length - 1][k];
        }

        for (int l = 0; l < path.length; l++) {
            System.out.print(path[l] + " ");
        }
        System.out.println();
        idx = 0;
        print(mat, m, n, i + 1, j, path, idx);
    }

    public static void main(String[] args) {
        MatrixTraversal matrixTraversal = new MatrixTraversal();
        int m = 2;
        int n = 3;
        int mat[][] = {{1, 2, 3},
                {4, 5, 6}};
        int maxLengthOfPath = m + n - 1;
        matrixTraversal.printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);

    }
}
