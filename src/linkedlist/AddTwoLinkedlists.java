package linkedlist;

import java.util.List;

/*
*     ou are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
* and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*
* */
public class AddTwoLinkedlists {
    private static ListNode head = null;

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public ListNode insertAfter(ListNode head, int value) {
        // new_node.next = null;
        if (head == null) {
            head = new ListNode(value);
        } else {
            head.next = insertAfter(head.next, value);
        }
        return head;
    }

    public ListNode insertAfterIteration(ListNode head, int value) {
        // new_node.next = null;
        if (head == null) {
            head = new ListNode(value);
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
        return head;
    }


    public ListNode mergeKList(List<ListNode> listNodeList) {
        for (ListNode li : listNodeList) {


        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), current = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;

        }
        if (l2 != null) {
            current.next = l2;
        }


        return dummyHead.next;
    }


    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2, ListNode dummy) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.data < l2.data) {
            dummy.next = mergeTwoListsIterative(l1.next, l2, dummy);
            return l1;
        } else {
            dummy.next = mergeTwoListsIterative(l1, l2.next, dummy);
            return l2;
        }
    }


    public static void main(String[] args) {
        //Input: lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode head = null;
        AddTwoLinkedlists l1 = new AddTwoLinkedlists();
        head = l1.insertAfterIteration(head, 1);
        head = l1.insertAfterIteration(head, 4);
        head = l1.insertAfterIteration(head, 5);
        ListNode head1 = null;
        head1 = l1.insertAfter(head1, 1);
        head1 = l1.insertAfter(head1, 3);
        head1 = l1.insertAfter(head1, 4);

        ListNode head2 = null;
        head2 = l1.insertAfter(head2, 2);
        head2 = l1.insertAfter(head2, 6);

        System.out.println(head);

        l1.mergeTwoLists(head1, head2);


        ListNode dummyHead = new ListNode(-1), current = dummyHead;
        ListNode result = l1.mergeTwoListsIterative(head1, head2, current);
        System.out.println(result);
    }
}
