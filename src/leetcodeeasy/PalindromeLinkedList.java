package leetcodeeasy;

public class PalindromeLinkedList {
    private static ListNode current;

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean reversLinkedList(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean isPalindrome = reversLinkedList(head.next) && head.val == current.val;
        current = current.next;
        return isPalindrome;
    }


    public boolean isPalindrome(ListNode l1, ListNode l2) {

        while (l1.next != null && l2.next != null) {

            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        return true;


    }


    public void printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            sb.append("->");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList p = new PalindromeLinkedList();
        p.printLinkedList(head);
        current = head;
        System.out.println("is Palindrome: " + p.reversLinkedList(head));
    }
}
