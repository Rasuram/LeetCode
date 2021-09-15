package allexamples;

import java.util.Stack;

public class Calculate {

    public int calculate(String s) {
        String trim = s.trim();
        Stack<Character> stack = new Stack<>();
        int current = 0;
        boolean pending = false;
        char operation = ' ';
        int sum = 0;
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);

            if (c == '(') {
                stack.push(c);
            }

            if (c == ' ') {
                continue;
            }
            if (pending) {
                switch (operation) {
                    case '+':
                        sum = current + Character.getNumericValue(c);
                        break;
                    case '-':
                        sum = current - Character.getNumericValue(c);
                        break;
                }
                current = sum;
                pending = false;
            } else if (c == '+' || c == '-') {
                pending = true;
                operation = c;
            } else {
                current = Character.getNumericValue(c);
            }
        }
        return sum;
    }


    private static void cal(String s) {
        s = s.trim();
        if (s.length() == 0) {
            System.out.println("expression must not empty");
        }
        String trim = s.trim();
        Stack<Character> stack = new Stack<>();
        boolean pending = false;
        char operation = ' ';
        int current = 0;
        int sum = 0;
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (pending) {
                switch (operation) {

                    case '+' -> sum = current + Character.getNumericValue(c);
                    case '-' -> sum = current - Character.getNumericValue(c);
                }
                pending = false;
            }
            if (c == '+' || c == '-') {
                stack.push(c);
                pending = true;
                operation = c;
            } else {
                current = Character.getNumericValue(c);

            }
        }
    }

    public static void main(String[] args) {
        String s = " 2-1 + 5 ";
        System.out.println(new Calculate().calculate(s));
    }
}



