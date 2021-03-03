package allexamples;

public class NumberReverse {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }

    }


    public static void main(String[] args) {
        NumberReverse n = new NumberReverse();
        System.out.println(n.reverse(-1534236469));
    }
}
