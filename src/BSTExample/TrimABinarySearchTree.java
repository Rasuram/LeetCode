package BSTExample;

public class TrimABinarySearchTree {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode trimBST(TreeNode root, int low, int high) {
        return recur(root, low, high);
    }

    public TreeNode recur(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        root.left = recur(root.left, low, high);
        root.right = recur(root.right, low, high);

        if (root.val < low) {
            return root.right;
        }
        if (root.val > high) {
            return root.left;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(3);
        t.right = new TreeNode(2);
        TrimABinarySearchTree b = new TrimABinarySearchTree();
        b.trimBST(t, 1, 2);
    }
}
