package leetcodeeasy;

import java.util.Arrays;

public class PrintPrimes {

    public int countPrimes(int n) {
        int counter = 0;
        if (n == 0 || n == 1) {
            return 0;
        }
        boolean[] isPrimeaRray = new boolean[n];
        Arrays.fill(isPrimeaRray, true);
        for (int i = 2; i < n; i++) {
            if (i != 2 && i % 2 == 0) {
                continue;
            }

            boolean isPRime = true;
            if (isPrimeaRray[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (i % j == 0) {
                        isPrimeaRray[i] = false;
                        isPRime = false;
                        break;
                    }
                }
                if (i == 2 || isPRime) {
                    counter++;
                }
            }
        }
        return counter;
    }


    public int countPrimes1(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // exculde 1 and n
        int count = n - 2;

        // only need to check to sqrt(n) as the rest pairs are equivalent to previous pairs
        for (int i = 2; i * i < n; i++) {
            // not prime, its multiples have already been checked
            if (!isPrime[i]) continue;
            // start from i since previous pairs have been checked
            for (int j = i; i * j < n; j++) {
                if (isPrime[i * j]) {
                    isPrime[i * j] = false;
                    count--;
                }
            }
        }

        return count;
    }




    public static void main(String[] args) {
        PrintPrimes c = new PrintPrimes();
      //  System.out.println(c.countPrimes(499979));
        System.out.println(c.countPrimes1(10));

    }
}
