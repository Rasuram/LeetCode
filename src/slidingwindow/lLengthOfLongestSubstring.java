package slidingwindow;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class lLengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {

        String result = "";
        int max = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int pos = result.indexOf(c);
            if (pos != -1) {
                result = result.substring(pos + 1);
            }
            result += c;
            max = Math.max(max, result.length());

        }
        return max;

    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "pwwkew";
        String s2 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
