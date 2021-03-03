package linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedlIstReverseSearch {

    private static List<Integer> reverseLinkedlist(LinkedList<Integer> linkedList, int begin, int end) {
        Integer[] arry = linkedList.toArray(new Integer[linkedList.size()]);
        begin--;
        end--;
        for (int i = begin; i <= end; i++) {
            int temp = arry[begin];
            arry[begin] = arry[end];
            arry[end] = temp;
            begin++;
            end--;

        }
        return new LinkedList(Arrays.asList(arry));

    }

    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        li.add(1);
        li.add(3);
        li.add(2);
        li.add(4);
        li.add(5);
        System.out.println(reverseLinkedlist(li,1,4));


    }

}
