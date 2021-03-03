package BSTExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * O(logn)
 *
 * Think of it as O(n*log(n)), i.e.
 * "doing log(n) work n times".
 * For example, searching for an element in a sorted list of length n is O(log(n)).
 * Searching for the element in n different sorted lists, each of length n is O(n*log(n)).
 * */

public class BalanceBinaryTreeFromArray {


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


    void inOrder(Node root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");//leftmidright
        inOrder(root.right);

    }

    void postOrder(Node root) {

        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.data + " ");//leftrightmid

    }

    public static void main(String[] args) {

        BalanceBinaryTreeFromArray b = new BalanceBinaryTreeFromArray();
        int[] arr = {15, 10, 20, 8, 12, 16, 25};
        int n = arr.length;
        Arrays.sort(arr);

        Node root = b.insertBalanceArray(arr, 0, n - 1, null);

        b.preOrder(root);
        b.inOrder(root);
        b.postOrder(root);

    }
}
