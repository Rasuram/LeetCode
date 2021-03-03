package leetcodeeasy.binaryTree;
/*Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary
tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 */


public class ConvertArrayToBinaryTree {


    public TreeNode constructTree(int[] arr) {
        return buildTree(arr, 0, arr.length - 1);
    }


    private TreeNode buildTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildTree(arr, start, mid - 1);
        node.right = buildTree(arr, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        ConvertArrayToBinaryTree c = new ConvertArrayToBinaryTree();
        TreeNode tree = c.constructTree(a);
        System.out.println(tree);
    }

}
