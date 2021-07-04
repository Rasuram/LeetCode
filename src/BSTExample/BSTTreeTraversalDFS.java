package BSTExample;

/*
* For example, given the tree:
   1
  / \
 2   3
    / \
   4   5
Return [[1, 2], [1, 3, 4], [1, 3, 5]].
* */

import leetcodeeasy.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTTreeTraversalDFS {

    List<List<Integer>> pathList = new ArrayList<>();

    public int[][] returnAllPaths(TreeNode root) {
        paths(root, new ArrayList<>());
        return null;
    }


    private void paths(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            pathList.add(list);
            list = new ArrayList<>();
        }
        paths(root.left, list);
        paths(root.right, list);

    }



    public static void main(String[] args) {
        BSTTreeTraversalDFS bfs = new BSTTreeTraversalDFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int[][] paths = bfs.returnAllPaths(root);
        System.out.println(paths);
    }
}
