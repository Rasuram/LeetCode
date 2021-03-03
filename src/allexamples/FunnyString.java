package allexamples;

/*
* ,
Corresponding ASCII values of characters of the strings:
 and
 *
The difference list for string  is [1, 21, 2] and for string  is [2, 21, 1].
*
* */
public class FunnyString {
    static String funnyString(String s) {
        int las_next = 0;
        int current_next = 0;
        int current_prev = 0;
        int n = s.length() - 1;
        for (int i = 0; i < n; i++) {
            int asciCode = s.charAt(i);
            int last = s.charAt(n - i);
            if (current_next == 0) {
                current_next = asciCode;
            } else if (Math.abs(asciCode-current_prev) != Math.abs((last - las_next))) {
               return "Not Funny";

            }
            las_next = last;
            current_prev = asciCode;
        }
        return "Funny";
    }

    public static void main(String[] args) {
        String s = "jkotzxzxrxtzytlruwrxytyzsuzytwyzxuzytryzuzysxvsmupouysywywqlhg";
        System.out.println(funnyString(s));
    }

}
