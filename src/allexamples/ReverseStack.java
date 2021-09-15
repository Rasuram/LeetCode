package allexamples;

import java.util.Stack;

public class ReverseStack {


    public static Stack<Integer> reverse(Stack<Integer> stack) {
        int n = stack.size();
        int first = 0;
        int last = stack.size() - 1;
        while (first < last) {
            int firstEl = stack.get(last);
            int lastEl = stack.get(first);
            stack.setElementAt(firstEl, first++);
            stack.setElementAt(lastEl, last--);
        }
        return stack;
    }

    public static void recursivestack(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return;
        }

        Integer remove = stack.remove(0);
        if (stack.size() > 0) {
            recursivestack(stack);
        }
        stack.push(remove);
    }


    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        //Stack result = reverse(s);
        //System.out.println(result);
       recursivestack(s);


    }
}
