package BSTExample;


public class LinkedListInBinaryTree {
    // Definition for singly-linked list.
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean isSubPathMatch(TreeNode root, ListNode l) {
        return dfs(root, l);
    }

    public boolean dfs(TreeNode root, ListNode head) {
        if (root == null) {
            return false;
        }
        if (isMatch(root, head)) {
            return true;
        }
        return dfs(root.left, head) || dfs(root.right, head);
    }

    public boolean isMatch(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null || root.val != head.val) {
            return false;
        }
        return isMatch(root.left, head.next) || isMatch(root.right, head.next);
    }


    public static void main(String[] args) {
        /*
         *         1
         *       /    \
         *              4
         *      4      /
         *       \     2
         *        2    / \
         *        /   6   8
         *       1       /  \
         *              1     3
         * Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
             Output: true
         * */
        LinkedListInBinaryTree linkedListInBinaryTree = new LinkedListInBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(6);

        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(6);
        System.out.println(linkedListInBinaryTree.isSubPathMatch(root, l));

    }
}
