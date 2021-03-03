package allexamples;

public class DigitManipulation {


    static int digitsManipulations(int n) {
        if (n < 10) return 0;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }
        return product - sum;
    }


    public static void main(String[] args) {
        System.out.println(digitsManipulations(99));
    }
}
