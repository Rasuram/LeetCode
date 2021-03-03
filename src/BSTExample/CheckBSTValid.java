package BSTExample;

public class CheckBSTValid {

    static class Node {
        int data;
        Node right, left;

        Node(int value) {
            data = value;
            right = null;
            left = null;
        }
    }

    boolean isValidBinaryTree(Node root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }

        return isValidBinaryTree(root.left, min, root.data - 1) &&
                isValidBinaryTree(root.right, root.data + 1, max);

    }


    public static void main(String[] args) {
        CheckBSTValid b = new CheckBSTValid();
        Node n = new Node(8);
        n.left = new Node(5);
        n.left.right = new Node(6);
        n.left.left = new Node(1);

        n.right = new Node(9);
        n.right.right = new Node(10);


        boolean isValid = b.isValidBinaryTree(n, 1, 10);
        System.out.println(isValid);

    }
}
