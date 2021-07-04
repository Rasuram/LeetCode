package BSTExample;

import leetcodeeasy.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreePaths {

    private List<String> pathList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuffer());
        return pathList;
    }


    public void dfs(TreeNode root, StringBuffer stringBuffer) {

        if (root == null) {
            return;
        }

        stringBuffer.append(root.val);
        if (root.left == null && root.right == null) {
            pathList.add(stringBuffer.toString());
            return;
        }
        stringBuffer.append("->");
        dfs(root.left, new StringBuffer(stringBuffer));
        dfs(root.right, new StringBuffer(stringBuffer));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        TreePaths tre = new TreePaths();
        List<String> targetRoots1 = tre.binaryTreePaths(root);
    }
}



