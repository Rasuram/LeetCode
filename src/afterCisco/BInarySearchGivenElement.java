package afterCisco;

import java.util.LinkedList;
import java.util.Queue;

public class BInarySearchGivenElement {

    static TreeNode tmp = null;
    static TreeNode tmp1 = null;

    public static void searchElementSorted(TreeNode root, int searchElement) {

        if (root == null) {
            return;
        }


        TreeNode result = dfs(root, searchElement);
        TreeNode result1 = bfs(root, searchElement);

        System.out.println(result.val);
        System.out.println(result1.val);
    }

    public static TreeNode dfs(TreeNode root, int searchElement) {

        if (root == null) {
            return null;
        }
        if (root.val == searchElement) {
            tmp = root;
        }
        dfs(root.left, searchElement);
        dfs(root.right, searchElement);
        return tmp;
    }

    public static TreeNode bfs(TreeNode root, int searchElement) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val == searchElement) {
                    tmp1 = node;
                    break;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

        }
        return tmp1;
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
        searchElementSorted(root, 7);
    }
}
