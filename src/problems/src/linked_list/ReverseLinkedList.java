package problems.src.linked_list;

public class ReverseLinkedList {
    private ListNode newHead;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // node5.next = node6;
        ListNode newNode = new ReverseLinkedList().reverseList(node1);
        System.out.println(newNode);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;
        //reverse(head).next = null;
        reverseWithoutRecur(head);
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        ListNode node = reverse(head.next);
        node.next = head;
        return head;
    }

    private void reverseWithoutRecur(ListNode head) {
        ListNode pointer = head;
        ListNode previous = null, current = null;
        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;
            // reverse the link
            current.next = previous;
            previous = current;
          newHead = current;
        }
    }
}
