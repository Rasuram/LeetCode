package allexamples;

public class CoinsSplit {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    private static int power(int number, int square) {
        if (square <= 0) {
            return 1;
        }
        return number + power(number, square - 1);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        CoinsSplit c =new CoinsSplit();
        //System.out.println(new allexamples.CoinsSplit().coinChange(coins, 20));
        System.out.println(power(3,3));
    }
}
