package BSTExample;

public class TwoBinaryTrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (q == null || p == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(3);
        TwoBinaryTrees tb = new TwoBinaryTrees();
        System.out.println(tb.isSameTree(t, t1));

    }

}


