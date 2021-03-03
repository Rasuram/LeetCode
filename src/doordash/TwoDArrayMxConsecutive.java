package doordash;


public class TwoDArrayMxConsecutive {
    int counter = 0;

    int mxConsecutive(int[][] A) {
        int size = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                // size+=dfs(A,i,j);
                size += A[i][j] + dfs(A, A[i][j], i - 1, j);
            }

        }

        return size;
    }

    private int dfs(int[][] A, int result, int i, int j) {
        if (A[0].length <= j) {
            return 1;
        }
        if (i >= 0 && j >= 0 && result == A[i][j]) {
            counter += dfs(A, result, i, j + 1);
            counter += dfs(A, result, i, j - 1);
        }
        return counter;
    }


    public static void main(String[] args) {
        int[][] A = {
                {5, 10, 10, 10},
                {10, 10, 50, 60},
                {45, 65, 15, 30}
        };
        System.out.println(new TwoDArrayMxConsecutive().mxConsecutive(A));
    }
}
