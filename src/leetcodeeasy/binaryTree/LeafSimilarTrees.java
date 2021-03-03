package leetcodeeasy.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTrees {

    List<Integer> l = new LinkedList<>();
    List<Integer> r = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        addLeafNodes(root1, l);
        addLeafNodes(root2, r);
        return l.equals(r);
    }

    public void addLeafNodes(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        addLeafNodes(root.left, list);
        addLeafNodes(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        LeafSimilarTrees l = new LeafSimilarTrees();
        System.out.println(l.leafSimilar(root1, root2));
    }
}
