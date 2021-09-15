package afterCisco;

/*
* This problem was asked by Morgan Stanley.
In Ancient Greece, it was common to write text with the first line going left to right, the second line going right to left, and continuing to go back and forth. This style was called "boustrophedon".
Given a binary tree, write an algorithm to print the nodes in boustrophedon order.
For example, given the following tree:
*        1
    /     \
  2         3
 / \       / \
4   5     6   7
/    \
8     10
You should return [1, 3, 2, 4, 5, 6, 7].
*
* */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeRightToLeftTraversal {
    private int sum = 0;

    public void traverseTree(TreeNode root) {
        if (root == null) {
            System.out.println("tree empty");
            return;
        }
        bfs(root);
    }

    public void bfs(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        q.add(root);
        int counter = 0;
        while (!q.isEmpty() || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                int size = stack.size();
                Stack<TreeNode> result = new Stack<>();
                for (int i = 0; i < size; i++) {
                    TreeNode current = stack.pop();
                    sb.append("->").append(current.val);
                    if (current.right != null) {
                        result.add(current.right);
                    }
                    if (current.left != null) {
                        result.add(current.left);
                    }
                }
                while (!result.isEmpty()) {
                    TreeNode current = result.pop();
                    sb.append("->" + current.val);
                }
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                sb.append("->" + current.val);
                if (counter % 2 == 0) {
                    if (current.left != null) {
                        stack.add(current.left);
                    }
                    if (current.right != null) {
                        stack.add(current.right);
                    }
                } else {
                    if (current.left != null) {
                        q.add(current.left);
                    }
                    if (current.right != null) {
                        q.add(current.right);
                    }
                }

            }
            counter++;
        }
        System.out.println(sb.toString() + "height of the tree" + counter);
    }

    public void dfs(TreeNode root, boolean isLeftTree) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && isLeftTree) {
            sum += root.val;
        }
        dfs(root.left, true);
        dfs(root.right, false);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(10);
        TreeRightToLeftTraversal t = new TreeRightToLeftTraversal();
        t.traverseTree(root);

        t.dfs(root, true);
        System.out.println(t.sum);
    }
}
