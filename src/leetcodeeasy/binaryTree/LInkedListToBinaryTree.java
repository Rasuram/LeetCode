package leetcodeeasy.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class LInkedListToBinaryTree {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }
    }

    public TreeNode construct(ListNode node) {
        List<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return construct(list);
    }


    public TreeNode construct(List<Integer> arr) {

        return construct(arr, 0, arr.size()-1);

    }

    private TreeNode construct(List<Integer> arr, int left, int right) {

        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = construct(arr, left, mid - 1);
        node.right = construct(arr, mid + 1, right);
        return node;
    }


    public TreeNode buildTreeFromLinkedList(ListNode node) {
        ListNode fast_ptr = node;
        ListNode slow_ptr = node;
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        System.out.println("mid value is:" + slow_ptr.val);
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        LInkedListToBinaryTree l = new LInkedListToBinaryTree();
        l.buildTreeFromLinkedList(head);
        l.construct(head);

    }
}
