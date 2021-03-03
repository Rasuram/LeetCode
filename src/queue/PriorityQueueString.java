package queue;

import java.util.PriorityQueue;

public class PriorityQueueString {


    public String reorganizeString(String S) {
        String str = "";
        PriorityQueue<Character> p = new PriorityQueue<>((a,b)->a-b);
        for (int i = 0; i < S.length(); i++) {
            p.add(S.charAt(i));
        }

        while (!p.isEmpty()) {
            char c = p.poll();
            if (str.length() > 0 && c == str.charAt(str.length() - 1)) {
                return "";
            }
            str += c;
        }

        return str;
    }


    public static void main(String[] args) {
        PriorityQueueString p = new PriorityQueueString();
        System.out.println(p.reorganizeString("aab"));
    }
}
