package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MinRemoveBrackets {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int deleted = 0;
        // first scan delete all unwanted closing braces without opening braces
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) { // unwanted closing braces found without the opening braces
                    deleted++; // make a note of counts of deleted unwanted braces
                    continue; // just skip without appending the brace
                }
                stack.pop();
            }
            sb.append(c);
        }
        // remove the extra opening braces found
        while(!stack.isEmpty()){
            sb.deleteCharAt(stack.pop() - deleted); // need to adjust the index in the new string as we didnt include it
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       // MinRemoveBrackets m = new MinRemoveBrackets();
        //System.out.println(m.minRemoveToMakeValid("lee(t(c)o)d)e)"));


        int[] t = {1, 1, 1, 1, 1};
        //List<Integer> list = new ArrayList(Arrays.asList(t));
        List<Integer> list = Arrays.stream(t).boxed().collect(Collectors.toList());
        if(list.contains(23)){
            System.out.println("equals");
        }
    }
}
