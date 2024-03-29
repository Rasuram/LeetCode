package allexamples;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DecodeString {

    public static void decode(String str) {

        // Map<Integer, String> m = new HashMap<>();
        Stack<String> characterStack = new Stack<>();
        Stack<Integer> integers = new Stack<>();
        //  StringBuffer sb = new StringBuffer();

        String ss = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                integers.push((Integer.valueOf(c + "")));
            } else if (c == '[') {
                characterStack.push(ss);
                ss = "";
            } else if (c == ']') {
                String sw = characterStack.pop();
                int m = integers.pop();
                for (int j = 0; j < m; j++) {
                    sw += ss;
                }
                ss = sw;
            } else {
                ss += c;
            }
        }
        System.out.println(ss);
    }


    private static void decodeString(String str) {
        Stack<String> characterStack = new Stack<>();
        Stack<Integer> digits = new Stack<>();
        String sb = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digits.push(Integer.valueOf(c + ""));
            } else if (c == '[') {
                characterStack.push(sb);
                sb = "";
            } else if (c == ']') {
                int n = digits.pop();
                String tmp = characterStack.pop();
                for (int j = 0; j < n; j++) {
                    tmp += sb;
                }
                sb = tmp;
            } else {
                sb += c;
            }


        }
        System.out.println(sb);

    }


    public static void main(String[] args) {
        String s = "3[a2[c]]";
        decode(s);
        decodeString(s);

    }
}
