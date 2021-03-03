package leetcodeeasy.binaryTree;


public class CompareTwoBinaryTrees {


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // root.left = new TreeNode();
        root.right = new TreeNode(2);

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);

        CompareTwoBinaryTrees c = new CompareTwoBinaryTrees();
        System.out.println(c.isSameTree(root, root1));
    }
}
