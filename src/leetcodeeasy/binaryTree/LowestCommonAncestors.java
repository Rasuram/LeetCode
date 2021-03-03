package leetcodeeasy.binaryTree;

/*
*
* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
* “The lowest common ancestor is defined between two nodes p and q as the lowest node
* in T that has both p and q as descendants (where we allow a node to be a descendant of
* */
public class LowestCommonAncestors {

    TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        return findLCA(root, p, q) ? lca : null;

    }

    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }
        boolean isLeftFound = findLCA(root.left, p, q);
        boolean isRightFound = findLCA(root.right, p, q);

        if (isLeftFound && isRightFound && lca == null) {
            lca = root;
        }
        if ((isRightFound || isLeftFound) && (lca == p || lca == q)) {
            lca = root;
        }
        if (root == p || root == q) {
            return true;
        }
        return isLeftFound && isRightFound;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        LowestCommonAncestors l = new LowestCommonAncestors();
        TreeNode t = l.lowestCommonAncestor(root, p, q);
        System.out.println(t);
    }


}
