package allexamples;

public class DigitSum {

    static int sumOfItsDigits(int number) {

        if (number < 10) {
            return number;
        }
        int sum = 0;
        while (number > 0) {

            int temp = number % 10;
            sum += temp;
            number = number / 10;
        }

        if (sum > 10) {
            return sumOfItsDigits(sum);
        }

        return sum;

    }


    public static void main(String[] args) {
        System.out.println(sumOfItsDigits(123456));

    }
}
