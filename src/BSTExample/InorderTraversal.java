package BSTExample;

public class InorderTraversal {


    class Node {
        int data;
        Node left, right = null;

        Node(int d) {
            this.data = d;
        }
    }


    Node prepAReBinaryTree(int value, Node root) {
        if (root == null) {
            return new Node(value);
        }

        if (root.data > value) {
            root.left = prepAReBinaryTree(value, root.left);
        } else if (root.data < value) {
            root.right = prepAReBinaryTree(value, root.right);
        }

        return root;

    }

    void inOrderTraversal(Node root) {

        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.println(root.data);
    }


    public static void main(String[] args) {
        InorderTraversal in = new InorderTraversal();
        Node root = null;
        int[] arr = {8,3,6,2,10,4,7,1,14,13};

        for (int i = 0; i < arr.length; i++) {
            root = in.prepAReBinaryTree(arr[i], root);
        }
        in.inOrderTraversal(root);


    }
}
