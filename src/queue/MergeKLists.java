package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
*
*
* Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
* */
public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> p = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node:lists){
            if(node!=null)
                p.add(node);
        }
        ListNode ret = new ListNode();
        ListNode temp = ret;

        while (!p.isEmpty()) {
            ListNode n = p.poll();
            temp.next = n;
            if (n.next != null) {
                p.add(n.next);
            }
            temp = temp.next;

            System.out.println(n);

        }

        return ret.next;
    }


    public static void main(String[] args) {
        MergeKLists m = new MergeKLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);


        ListNode[] lists = new ListNode[]{l1, l2, l3};
        m.mergeKLists(lists);
    }
}
