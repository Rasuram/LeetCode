package leetcodeeasy;

public class HappyNumber {

    public boolean isHappy(int n) {

        if (n == 0 || n == 1) {
            return true;
        }

        int tmp = 0;
        while (n > 0) {
            int divisor = n % 10;

            tmp = divisor * divisor + tmp;
            n = n / 10;
        }

        return isHappy(tmp);
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(3));
    }
}
