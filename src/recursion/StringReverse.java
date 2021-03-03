package recursion;

/*
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the
 * start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 *
 * */
public class StringReverse {

    public static String printReverse(String text) {
        return recursionReverse("", text, text.length() - 1);
    }


    public static String recursionReverse(String result, String text, int position) {

        if (position < 0) {
            return result;
        }

        result += text.charAt(position--);
        return recursionReverse(result, text, position);
    }


    public static String reverseStr(String s, int k) {

        return rever(s, "", 0, k);
    }


    public static String rever(String s, String result, int beginIndex, int endIndex) {

        if (beginIndex > s.length() - endIndex) {
            result += s.substring(result.length());
            return result;
        }
        result += new StringBuffer(s.substring(beginIndex, beginIndex + endIndex)).reverse().toString();

        beginIndex += 2 * endIndex;
        if (beginIndex < s.length() - endIndex && (result.length()<2 * endIndex)) {
            result += s.substring(result.length(), 2 * endIndex);
        }
        return rever(s, result, beginIndex, endIndex);
    }


    public static char[] reverse(char[] s) {

        char[] c = new char[s.length];
        int counter = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            c[counter++] = s[i];
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(printReverse("abcde"));
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        // System.out.println(reverse(c).toString());

        System.out.println(reverseStr("abcdefg", 1));

    }
}
