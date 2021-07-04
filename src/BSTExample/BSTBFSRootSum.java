package BSTExample;

import leetcodeeasy.binaryTree.TreeNode;

import java.util.*;

public class BSTBFSRootSum {

    public static List<TreeNode> BFS(TreeNode root, int targetSum) {

        Queue<TreeNode> s = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        s.add(root);
        while (!s.isEmpty()) {
            for (int i = 0; i < s.size(); i++) {
                TreeNode node = s.poll();
                if (node == null) return list;
                if (node.left != null && node.right != null) {
                    if (node.left.val + node.right.val == targetSum) {
                        list.add(node.left);
                        list.add(node.right);
                        return list;
                    }
                }
                if (node.left != null) {
                    s.add(node.left);
                }

                if (node.right != null) {
                    s.add(node.right);
                }
            }
        }
        return list;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }


    public static List<Integer> pairSum(TreeNode root, int targetSum) {

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) + list.get(end) == targetSum) {
                return Arrays.asList(list.get(start), list.get(end));
            }
            if (list.get(start) + list.get(end) > targetSum) {
                end--;
            }
            if (list.get(start) + list.get(end) < targetSum) {
                start++;
            }
        }

        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);

        List<TreeNode> targetRoots1 = BFS(root, 16);
        List<Integer> targetRoots = pairSum(root, 16);
        System.out.println();
    }
}
