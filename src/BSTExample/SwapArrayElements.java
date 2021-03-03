package BSTExample;

public class SwapArrayElements {
    public int[] sortedSquares(int[] A) {
        boolean flag = false;
        for (int i = 1; i < A.length; i++) {
            int prev = A[i - 1];
            int current = A[i];
            if (prev > current) {
                A[i] = prev;
                A[i - 1] = current;
                flag = true;

            }

        }

        return flag ? sortedSquares(A) : A;
    }

    private static  int[] multiply(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }
        return a;
    }


    public static void main(String[] args) {
        SwapArrayElements s = new SwapArrayElements();
        int[] A = {-4, -1, 0, 3, 10};
        int[] B = s.sortedSquares(multiply(A));
        System.out.println(A);
    }
}

