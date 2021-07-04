package BSTExample;

import leetcodeeasy.binaryTree.TreeNode;

public class BSTTargetSum {


    public static boolean isTargetMatch(TreeNode root, int currentSum, int sum) {
        if (root == null) {
            return false;
        }
        currentSum += root.val;
        if (currentSum == sum) {
            return true;
        }
        return isTargetMatch(root.left, currentSum, sum) || isTargetMatch(root.right, currentSum, sum);
    }


    public static void main(String[] args) {
        //8,3,6,10,4,7,1,14,13
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);
        System.out.println(isTargetMatch(root, 0, 22));
    }
}
