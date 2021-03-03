package BSTExample;

public class BinaryTreeSearch {

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

    int searchValue(Node root, int data) {
        if (root == null) {
            return -1;
        }
        if (root.data == data) {
            return 1;
        }

        if (root.data > data) {
            return searchValue(root.left, data);
        } else {
            return searchValue(root.right, data);
        }
    }


    public static void main(String[] args) {
        BinaryTreeSearch b = new BinaryTreeSearch();
        Node n = new Node(8);
        n.left = new Node(5);
        n.left.right = new Node(6);
        n.left.left = new Node(1);

        n.right = new Node(9);
        n.right.right = new Node(10);


        int found = b.searchValue(n, 11);
        System.out.println(found);

    }
}
