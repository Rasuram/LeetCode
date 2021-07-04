package allexamples;

import BSTExample.LinkedListInBinaryTree;
import leetcodeeasy.binaryTree.LInkedListToBinaryTree;

public class LInkedListIntersection {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void getIntersectionNode(ListNode headA, ListNode headB) {

        intersection(headA, headB);
        //  System.out.println(result);
    }

    public static void intersection(ListNode l1, ListNode l2) {

        if (l1.next == null) {
            return;
        }
        if (l2.next == null) {
            return;
        }


        intersection(l1.next, l2);
        intersection(l2.next, l1);
        //[7, 1, 2, 9, 7, 2, 1]

        if (l1.next.val == l2.next.val) {
            System.out.println(l1.val);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);

        getIntersectionNode(head, head1);
    }
}
