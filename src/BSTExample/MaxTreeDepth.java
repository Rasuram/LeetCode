package BSTExample;

import java.util.Arrays;

public class MaxTreeDepth {


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }


    Node insertBalanceArray(int[] keys, int low, int high, Node root) {

        if (low > high) {
            return root;
        }
        // find middle element of current range
        int mid = (low + high) / 2;

        // construct a new node from mid element and assign it to root
        root = new Node(keys[mid]);

        // left subtree of root will be formed by keys less than mid element
        root.left = insertBalanceArray(keys, low, mid - 1, root.left);

        // right subtree of root will be formed by keys less than mid element
        root.right = insertBalanceArray(keys, mid + 1, high, root.right);

        return root;
    }


    Node insertBalanceArray(int[] keys, Node root, int i) {

        if (i < keys.length) {
            root = new Node(keys[i]);
            root.left = insertBalanceArray(keys, root.left, 2 * i + 1);
            root.right = insertBalanceArray(keys, root.right, 2 * i + 2);
        }
        return root;
    }


    void preOrder(Node root) {

        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");//midleftright
        preOrder(root.left);
        //System.out.println(root.data + " ");//leftmidright
        preOrder(root.right);
        //System.out.println(root.data + " ");//leftrightmid

    }


    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        MaxTreeDepth b = new MaxTreeDepth();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        //  Arrays.sort(arr);

        //balanced tree
      //  allexamples.Node root = b.insertBalanceArray(arr, 0, n - 1, null);
        //same order
        Node root = b.insertBalanceArray(arr, null,0);
        //b.preOrder(root);

        System.out.println(b.maxDepth(root));
    }


}
