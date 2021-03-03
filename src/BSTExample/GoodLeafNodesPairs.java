package BSTExample;
/*
* Given the root of a binary tree and an integer distance.
* A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.
* */

public class GoodLeafNodesPairs {
    int ans = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(distance, root);
        return ans;
    }

    int[] dfs(int distance, TreeNode root) {
        int[] f = new int[distance + 1];
        if (root == null) {
            return f;
        }
        if (root.left == null && root.right == null) {
            f[0] = 1;
            return f;
        }
        int[] leftCount = dfs(distance, root.left);
        int[] rightCount = dfs(distance, root.right);

        for (int i = 0; i < leftCount.length; i++) {
            for (int j = 0; j < rightCount.length; j++) {
                if (i + 1 + j + 1 <= distance) {
                    ans += leftCount[i] * rightCount[j];
                }
            }
        }
        for (int i = 0; i < f.length - 1; i++) {
            f[i + 1] = leftCount[i] + rightCount[i];
        }
        return f;
    }

    public static void main(String[] args) {
        GoodLeafNodesPairs b = new GoodLeafNodesPairs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        //  b.pruneTree(root);
        b.countPairs(root, 3);
    }
}
