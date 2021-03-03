package linkedlist;

public class LinkedListMergeSort {


    ListNode head1;

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
            this.next = null;
        }

    }


    // Complete the reverse function below.
    static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        // last node or only one node
        if (head.next == null) {
            return head;
        }

        ListNode newHeadNode = reverse(head.next);

        // change references for middle chain
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode;
    }




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = null;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        l1 = reverse(l1);
        while (l1.next != null) {
            str1.append(l1.data);
            l1 = l1.next;
        }

        l2 = reverse(l2);
        while (l2.next != null) {
            str2.append(l2.data);
            l2 = l2.next;
        }

        str1.append(l1.data);
        str2.append(l2.data);
        int n = Integer.parseInt(str1.toString()) + Integer.parseInt(str2.toString());
        while (n > 0) {
            head1 = insertBefore(new ListNode(n % 10), head1);
            n = n / 10;
        }
        return head1;
    }

    private ListNode insertBefore(ListNode newListNode) {
        newListNode.next = newListNode;
        head1 = newListNode;
        return head1;
    }


    private ListNode insertAfter(ListNode head, int data) {
        // Create a new node with given data
        ListNode new_node = new ListNode(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            ListNode last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return head;
    }

    private ListNode insertBefore(ListNode newListNode, ListNode head1) {
        newListNode.next = head1;
        head1 = newListNode;
        return head1;
    }

    private ListNode merge(ListNode A, ListNode B) {

        if (A == null) return A;
        if (B == null) return B;

        if (A.data < B.data) {
            A.next = merge(A.next, B);
            return A;
        } else {
            B.next = merge(A, B.next);
            return B;
        }

    }


    public static void main(String[] args) {
        ListNode head = null;
        LinkedListMergeSort l1 = new LinkedListMergeSort();
        head = l1.insertAfter(head, 2);
        head = l1.insertAfter(head, 4);
        head = l1.insertAfter(head, 3);

        LinkedListMergeSort l2 = new LinkedListMergeSort();

        ListNode head1 = null;
        head1 = l2.insertAfter(head1, 5);
        head1 = l2.insertAfter(head1, 6);
        head1 = l2.insertAfter(head1, 4);

        ListNode result = l1.merge(head,head1);
        System.out.println(result);

        l1.addTwoNumbers(head, head1);
    }
}
