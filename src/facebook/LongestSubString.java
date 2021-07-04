package facebook;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {


    static int getLongestSubCount(String s) {
        Set<Character> unique = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < s.length()) {
            if (!unique.contains(s.charAt(j))) {
                unique.add(s.charAt(j));
                j++;
                max = Math.max(unique.size(), max);

            } else {
                unique.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(getLongestSubCount("nndNfdfdf"));
    }
}
