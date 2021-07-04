package allexamples;

import java.util.*;

public class DuplicateCharacters {
    public static String removeDuplicateLetters(String s) {

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
            set.add(c);

        }
        StringBuffer sb = new StringBuffer();
        set.forEach(sb::append);
        return sb.toString();

    }


    public static String removeDuplicates(String s) {

        //cbacdcbc

        System.out.println('f' - 'a');
        StringBuffer sb = new StringBuffer();

        for (char c : s.toCharArray()) {
            if (!sb.isEmpty()) {
                if (sb.toString().contains(c + "")) {
                    if (sb.charAt(0) == c) {
                        sb = new StringBuffer(sb.substring(1));
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


    public static String remove1(String s) {

        int n = s.length();
        // 1.
        int[] lastOccurrence = new int[128];
        for (int i = 0; i < n; i++) {
            lastOccurrence[s.charAt(i)] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> seen = new HashSet<>();
        // 2.
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (seen.add(c)) {
                while (!stack.isEmpty() && stack.peek() > c && lastOccurrence[stack.peek()] > i) {
                    seen.remove(stack.pop());
                }
                // 3.
                stack.push(c);
            }
        }

        // 5.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        // 6.
        return sb.reverse().toString();
    }


    public static String duplicates(String st, int i) {

        if (i > st.length()) {
            return st;
        }
        char c = st.charAt(i);
        if (st.indexOf(c) >= 0) {
            st = st.substring(i);
        }
        return duplicates(st, ++i);
    }

    public static int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public static int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }


    public static void main(String[] args) {
        //System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicates("cbacdcbc"));


        // System.out.println(remove1("cbacdcbc"));
        int[] s = {12, 3, 5, 4, 101, 18};
        System.out.println(lengthOfLIS(s));
    }

}
