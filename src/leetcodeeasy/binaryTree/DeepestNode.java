package leetcodeeasy.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
Good morning! Here's your coding interview problem for today.
This problem was asked by Google.
Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.
 */
public class DeepestNode {
    public static class TreeNodeChar {
        char val;
        TreeNodeChar left = null;
        TreeNodeChar right = null;

        TreeNodeChar(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public TreeNodeChar deepestNode(TreeNodeChar root) {


        Queue<TreeNodeChar> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNodeChar tc = q.poll();
                if (q.isEmpty() && tc.left == null && tc.right == null) return tc;
                if (tc.left != null) {
                    q.add(tc.left);
                }
                if (tc.right != null) {
                    q.add(tc.right);
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        DeepestNode d = new DeepestNode();
        TreeNodeChar root1 = new TreeNodeChar('a');
        root1.left = new TreeNodeChar('b');
        root1.left.left = new TreeNodeChar('d');
        root1.right = new TreeNodeChar('c');
        TreeNodeChar deep = d.deepestNode(root1);
        System.out.println(deep);
    }
}
