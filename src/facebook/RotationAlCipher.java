package facebook;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RotationAlCipher {

    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if ((c < 65) || (c > 122)) {
                sb.append(c);
            } else {
                sb.append((char) (c + rotationFactor));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rotationalCipher("123", 3));
        //nopqrstuvwxyzABCDEFGHIJKLM9012345678
        String s = "abcde";
        String t = "adcbe";
        int counter = 0;
        char[] c = s.toCharArray();
        char temp = c[c.length - 2];
        c[c.length - 2] = c[1];
        c[1] = temp;
        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];
            char c2 = t.charAt(i);
            if (c1 == c2) {
                counter++;
            }
        }
        System.out.println(counter);

        String s1 = "dcbefebce";
        String t1 = "fd";
       // StringBuilder sb = new StringBuilder();
        char[] ch = s1.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        sb.append(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] != ch[i - 1]) {
                sb.append(ch[i]);
            }
        }

        char[] ch1 = sb.toString().toCharArray();

        String sttt = new String(ch1);
        for(int i=0;i<t1.length();i++){
           int in =  sttt.indexOf(ch[i]);

        }

        System.out.println(ch1);
    }
}
