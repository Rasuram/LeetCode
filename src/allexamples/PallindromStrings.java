package allexamples;

import java.util.ArrayList;
import java.util.List;

public class PallindromStrings {


    public static List<String> getPlaindromStrings(String input) {

        char[] c = input.toCharArray();

        List<String> result = new ArrayList<>();

        for (int i = 0; i < c.length; i++) {
            String res = c[i] + "";
            boolean isPal = false;
            for (int j = i + 1; j < c.length; j++) {
                res = res + c[j];
                if (isPalindrome(res)) {
                    i = j;
                    result.add(res);
                    isPal = true;
                    break;
                }
            }
            if (!isPal) {
                result.add(c[i]+"");
            }
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        StringBuilder input1 = new StringBuilder(str);
        return str.equals(input1.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(getPlaindromStrings("racecarannakayak"));
        System.out.println(getPlaindromStrings("abc"));
    }
}
