package BSTExample;

import java.util.ArrayList;
import java.util.List;

public class BInaryTreeWithArrayOrder {
    Node root;

    class Node {
        int data;
        Node left, right = null;

        Node(int d) {
            this.data = d;

        }
    }


   /* allexamples.Node insert(int[] arr, int low, int high, allexamples.Node root) {
        if (low > high) {
            return root;
        }
        int mid = (low + high) / 2;
        int value = arr[mid];

        root = new allexamples.Node(value);

        root.left = insert(arr, low, mid - 1, root.left);
        root.right = insert(arr, mid + 1, high, root.left);
        return root;
    }*/

    Node insertLevelOrder(int[] arr, Node root, int i) {
        if (i < arr.length && arr[i] > 0) {
            Node temp = new Node(arr[i]);
            root = temp;
            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                    2 * i + 2);
        }
        return root;
    }

    List<Integer> longestPath(Node root) {
        if (root == null) {
            List l = new ArrayList();
            return new ArrayList<>();
        }
        List<Integer> right = longestPath(root.right);
        List<Integer> left = longestPath(root.left);

        if (right.size() < left.size()) {
            left.add(root.data);
        } else {
            right.add(root.data);
        }
        return (left.size() > right.size()) ? left : right;

    }


    public static void main(String[] args) {
        BInaryTreeWithArrayOrder b = new BInaryTreeWithArrayOrder();
        int[] arr = {1, 2, 3, 4, -1, -1, -1};

        b.root = b.insertLevelOrder(arr, b.root, 0);
        System.out.println(b.longestPath(b.root));
    }
}
