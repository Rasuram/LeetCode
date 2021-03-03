package leetcodeeasy.binaryTree;

/*
* Given the root of a binary tree and an integer targetSum,
* return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.
*
* */
public class PathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int actualSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            actualSum += root.val;
            return actualSum == targetSum;

        }


        return dfs(root.left, targetSum, actualSum + root.val) ||
                dfs(root.right, targetSum, actualSum + root.val);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(3);
/*        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);*/

        PathSum p = new PathSum();
        // System.out.println(p.hasPathSum(root, 22));
        System.out.println(p.hasPathSum(root, 1));
    }
}
