package leetcodeeasy.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
*
* Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
 *
* */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        return rangeSumBST(root, low, high, 0);

    }

    private int rangeSumBST(TreeNode root, int low, int high, int sum) {
        if (root == null) {
            return sum;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        sum = rangeSumBST(root.left, low, high, sum);
        sum = rangeSumBST(root.right, low, high, sum);
        return sum;
    }


    private int rangeSumBSTIterate(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }
            if (current.left != null && current.val > low) {
                q.add(current.left);
            }
            if (current.right != null && current.val < high) {
                q.add(current.right);
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(15);
        //root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(18);

        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(root, 7, 15));
        System.out.println(rangeSumBST.rangeSumBSTIterate(root, 7, 15));
    }
}



