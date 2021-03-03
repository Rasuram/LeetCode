package BSTExample;

public class BSTValid {

    public static class Node {
        int data;
        Node left;
        Node right;

    }

    public static class BST {

        public Node createNewNode(int k) {
            Node n = new Node();
            n.data = k;
            n.left = null;
            n.right = null;
            return n;
        }

        public Node insert(Node n, int value) {
            if (n == null) {
                return createNewNode(value);
            }
            if (value < n.data) {
                n.left = insert(n.left, value);
            } else if (value > n.data) {
                n.right = insert(n.right, value);
            }
            return n;
        }

        public boolean isSubTreeSubLessor(Node root, int value) {
            if (root == null) {
                return true;
            }
            return root.data <= value && isSubTreeSubLessor(root.left, value);
        }

        public boolean isSubTreeGreater(Node root, int value) {
            if (root == null) {
                return true;
            }
            return root.data >= value && isSubTreeGreater(root.left, value);
        }


        public boolean isTreeValid(Node root) {

            if (root == null) {
                return true;
            }
            return isSubTreeSubLessor(root.left, root.data) &&
                    isSubTreeGreater(root.right, root.data) && isTreeValid(root.left) && isTreeValid(root.right);
        }

    }

    public static void main(String[] args) {
        BST b = new BST();
        Node root = null;
        //8,3,6,10,4,7,1,14,13
        root = b.insert(root, 180);
        root = b.insert(root, 150);
        root = b.insert(root, 250);
        root = b.insert(root, 200);
        root = b.insert(root, 300);
        System.out.println(b.isTreeValid(root));


    }
}
