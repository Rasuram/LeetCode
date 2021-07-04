package dp;

import java.util.Arrays;

public class Fibonacci {


    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int n1 = fib(n - 1);
        int n2 = fib(n - 2);

        return n1 + n2;
    }

    public static int fibDp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibDp2(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        int first;
        int second;

        if (dp[n - 1] != -1) {
            first = dp[n - 1];
        } else {
            first = fibDp2(n - 1, dp);
        }

        if (dp[n - 2] != -1) {
            second = dp[n - 2];
        } else {
            second = fibDp2(n - 2, dp);
        }

        return dp[n] = first + second;//memoization
    }


    public static void main(String[] args) {
        System.out.println(fib(8));
        System.out.println(fibDp(8));
        int[] n = new int[9];
        Arrays.fill(n, -1);
        System.out.println(fibDp2(8, n));
    }
}
