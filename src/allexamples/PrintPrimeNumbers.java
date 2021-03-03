package allexamples;

public class PrintPrimeNumbers {


    static void printPrimes(int from, int to) {

        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                System.out.println("prime number is==>>" + i);
            }
        }
    }

    private static boolean isPrime(int num) {

        for (int i = 2; i <=num / 2; i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {

        printPrimes(0, 20);


    }

}
