package leetMedium;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static int coinChange1(int[] coins, int sum) {
        int totalCoins = coins.length;
        // Creating array which stores subproblems' solutions
        double[][] arr = new double[totalCoins + 1][sum + 1];

        // Initialising first row with +ve infinity
        for (int j = 0; j <= sum; j++) {
            arr[0][j] = Double.POSITIVE_INFINITY;
        }

        // Initialising first column with 0
        for (int i = 1; i <= totalCoins; i++) {
            arr[i][0] = 0;
        }

        // Implementing the recursive solution
        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j)
                    arr[i][j] = Math.min(1 + arr[i][j - coins[i - 1]], arr[i - 1][j]);
                else
                    arr[i][j] = arr[i - 1][j];
            }
        }

        return (int) arr[totalCoins][sum] > sum ? -1 : (int) arr[totalCoins][sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange1(coins, 11));
    }
}
