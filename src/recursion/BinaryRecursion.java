package recursion;


public class BinaryRecursion {

    static class Node {
        int data;
        Node left, right = null;

        Node(int d) {
            this.data = d;

        }
    }


    public int sumOfNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right);
    }


    public static void main(String[] args) {
        Node n = new Node(0);
        n.left = new Node(1);
        n.left.left = new Node(3);
        n.left.right = new Node(4);

        n.right = new Node(2);
        n.right.left = new Node(5);
        n.right.right = new Node(6);

        BinaryRecursion b = new BinaryRecursion();
        System.out.println(b.sumOfNodes(n));

    }
}
