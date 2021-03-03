package sort;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKsortedArrays {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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

    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> p = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null)
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
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode head = null;
        MergeKsortedArrays l1 = new MergeKsortedArrays();
        head = l1.insertAfter(head, 1);
        head = l1.insertAfter(head, 4);
        head = l1.insertAfter(head, 5);
        ListNode head1 = null;
        head1 = l1.insertAfter(head1, 1);
        head1 = l1.insertAfter(head1, 3);
        head1 = l1.insertAfter(head1, 4);

        ListNode head2 = null;
        head2 = l1.insertAfter(head2, 2);
        head2 = l1.insertAfter(head2, 6);

        ListNode result = l1.mergeKLists(Arrays.asList(head, head1, head2));
        System.out.println(result);
    }
}
