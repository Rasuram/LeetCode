package leetcodeeasy.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
*
*
* */
public class MinimumDepthOfBinaryTree {


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = q.poll();
                if (current.left == null && current.right == null) return level;
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            level++;

        }
        return level;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        MinimumDepthOfBinaryTree min = new MinimumDepthOfBinaryTree();
        min.minDepth(treeNode);
    }
}
