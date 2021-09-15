package afterCisco;


public class ListNode {

    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode(int data, ListNode next, ListNode prev) {
        this.val = data;
        this.next = next;
        this.prev = prev;
    }
}
