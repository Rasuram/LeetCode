package afterCisco;

import java.util.Stack;

public class DecodeStrings {

    public static String decodeMe(String str) {

        Stack<String> charA = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        char[] chars = str.toCharArray();

        String sb = "";
        for (char c : chars) {

            if (Character.isDigit(c)) {
                numbers.push(Integer.valueOf(c + ""));
            } else if (c == '[') {
                charA.push(sb);
                sb = "";
            } else if (c == ']') {
                String pop = charA.pop();
                int numb = numbers.pop();
                for (int i = 0; i < numb; i++) {
                    pop += sb;
                }
                sb = pop;
            } else {
                sb += c;
            }


        }

        return sb;

    }


    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeMe(s));

    }
}
