package leetcodeeasy.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
* In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
* */
public class CousinsInBinaryTree {
    int level = -1;
    int xparent = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        int leftLevel = findDepth(root, x, 0);
        int rightLevel = findDepth(root, y, 0);

        boolean isSameParent = isSameParentNode(root, x, y);

        System.out.println(leftLevel + rightLevel);

        return !isSameParent && leftLevel == rightLevel;

    }

    public boolean isSameParentNode(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) return false;
        if (root.left != null && root.right != null) {
            if ((root.left.val == x && root.right.val == y) || (root.right.val == x && root.left.val == y)) {
                return true;
            }
        }
        boolean left = isSameParentNode(root.left, x, y);
        boolean right = isSameParentNode(root.right, x, y);

        return left || right;

    }


    public boolean isCousinsWIthQuue(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }

        Queue<TreeNode> cousins = new LinkedList<>();
        cousins.add(root);
        while (!cousins.isEmpty()) {
            int n = cousins.size();
            boolean isXFound = false;
            boolean isYFound = false;
            for (int i = 0; i < n; i++) {
                TreeNode current = cousins.poll();
                if (current == null) break;
                if (current.left != null && current.right != null &&
                        current.right.val == x && current.left.val == y) {
                    return false;
                }
                if (current.left != null && current.right != null &&
                        current.left.val == x && current.right.val == y) {
                    return false;
                }
                if (current.val == x) isXFound = true;
                if (current.val == y) isYFound = true;
                if (current.left != null) {
                    cousins.add(current.left);
                }
                if (current.right != null) {
                    cousins.add(current.right);
                }
                if (isXFound && isYFound) {
                    return true;
                }
            }

        }
        return false;
    }

    public int findDepth(TreeNode root, int x, int level) {
        if (root == null) {
            return 0;
        }
        if (root.val == x) {
            return level;
        }
        int lh = findDepth(root.left, x, level + 1);
        int rh = findDepth(root.right, x, level + 1);

        return lh != 0 ? lh : rh;

    }

    public int findDepth(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        if (root.val == x) {
            return 1;
        }
        return Math.max(findDepth(root.left, x), findDepth(root.right, x)) + 1;
    }

    public boolean findDepth(TreeNode root, int x, int y, int height) {
        if (root == null) {
            return false;
        }
        if (root.val == x) {
            if (this.level == -1) {
                this.level = height;
            } else {
                return this.level == height;
            }
        }
        this.xparent = root.val;
        boolean l = findDepth(root.left, x, y, height + 1);
        boolean r = findDepth(root.right, y, x, height + 1);
        return l || r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        //   root.right.right = new TreeNode(6);
        CousinsInBinaryTree c = new CousinsInBinaryTree();
        System.out.println(c.isCousins(root, 5, 4));
        //System.out.println(c.isCousinsWIthQuue(root, 5, 4));
        //  System.out.println(c.findDepth(root, 0));
    }
}
