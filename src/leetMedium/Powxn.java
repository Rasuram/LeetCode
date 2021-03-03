package leetMedium;

/*
* Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
*Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*
* Input: x = 2.10000, n = 3
Output: 9.26100
* */
public class Powxn {

    /*   public double myPow(double x, int n) {
           double power = Math.pow(x, n);
           if (n < 0) {
               return 1 / power;
           }
           return power;
       }*/
    public double myPow(double x, int n) {
        return getPow(x, n);
    }

    public double getPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0 && n > Integer.MIN_VALUE) {
            return getPow(1 / x, -n);
        }

        double product = getPow(x, n / 2);
        if (n % 2 == 0) {
            return product * product;
        }
        return product * product * x;
    }


    public static void main(String[] args) {
        Powxn p = new Powxn();
        System.out.println(p.myPow(2.00000, 15));
        //System.out.println(p.myPow(2.00000, -2));
        String str = "hello";
        System.out.println(str.indexOf("ll"));
        System.out.println(indexOf("a", "la"));

    }

    public static int indexOf(String input, String substring) {

        int index = 0;
        int found = 0;
        for (int i = 0; i < input.length(); i++) {

            if (found > 0 && index < substring.length()) {
                if (input.charAt(i) == substring.charAt(index)) {
                    index++;
                } else {
                    return -1;
                }
            } else if (index < substring.length() && input.charAt(i) == substring.charAt(index)) {
                if (index == 0) {
                    found = i;
                }
                index++;
            }
        }
        return found == 0 && index == 0 ? -1 : found;
    }
}
