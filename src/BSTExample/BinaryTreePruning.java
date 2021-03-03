package BSTExample;

public class BinaryTreePruning {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }


    public TreeNode pruneTree1(TreeNode root) {

        if (root == null) {
            return root;
        }

        root.left = pruneTree1(root.left);
        root.right = pruneTree1(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreePruning b = new BinaryTreePruning();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        //  b.pruneTree(root);
        b.pruneTree1(root);
    }

}
