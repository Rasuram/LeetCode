package BSTExample;

public class BinaryAncestor {

    static class Node {
        int data;
        Node right, left;

        Node(int value) {
            data = value;
            right = null;
            left = null;
        }
    }

        /*
             8
           5     9
         1   6      10
      */

    Node findCommonAncestor(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }
        if (root.data > n1 && root.data > n2) {
            return findCommonAncestor(root.left, n1, n2);
        }
        if (root.data < n1 && root.data < n2) {
            return findCommonAncestor(root.right, n1, n2);
        }
        return root;
    }


    public static void main(String[] args) {
        BinaryAncestor b = new BinaryAncestor();
        Node n = new Node(8);
        n.left = new Node(5);
        n.left.right = new Node(6);
        n.left.left = new Node(1);

        n.right = new Node(9);
        n.right.right = new Node(10);


       Node ancestor =  b.findCommonAncestor(n, 6, 9);
        System.out.println(ancestor.data);

    }
}

