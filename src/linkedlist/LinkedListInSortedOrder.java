package linkedlist;

public class LinkedListInSortedOrder {
    static ListNode head;

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
            this.next = null;
        }

        ListNode() {

        }

    }

    static void buildLinkedList(int[] arr) {

        ListNode current;
        for (int value : arr) {
            ListNode new_node = new ListNode(value);
            if (head == null || head.data > value) {
                new_node.next = head;
                head = new_node;
            } else {
                current = head;
                while (current.next != null && current.next.data<value) {
                    current = current.next;
                }
                current.next = new_node;
            }


        }
    }


    public static void main(String[] args) {
        int[] input = {3, 4, 2, 6, 7, 8};
        buildLinkedList(input);
        System.out.println(head);
    }
}
