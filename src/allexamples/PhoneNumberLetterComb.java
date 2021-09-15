package allexamples;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberLetterComb {
    static String[] array;

    public static List<String> getLetterCombination(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)
            return list;
        array = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recursion1(digits, new StringBuilder(), list);
        return list;
    }

    public static void recursion(String digits, StringBuilder sbr, List<String> result) {
        if (digits.length() == 0) {
            result.add(sbr.toString());
            return;
        }
        char[] str = array[digits.charAt(0) - '0'].toCharArray();
        for (char c : str) {
            sbr.append(c);
            recursion(digits.substring(1), sbr, result);
            sbr.delete(sbr.length() - 1, sbr.length());
        }

    }


    public static void recursion1(String digits, StringBuilder sb, List<String> result) {

        if (digits.length() == 0) {
            result.add(sb.toString());
            return;
        }
        char[] ch = array[digits.charAt(0) - '0'].toCharArray();
        for (char c : ch) {
            sb.append(c);
            recursion1(digits.substring(1), sb, result);
            sb.delete(sb.length() - 1, sb.length());
        }

    }


    public static void main(String[] args) {
        System.out.println(getLetterCombination("23"));
    }
}
