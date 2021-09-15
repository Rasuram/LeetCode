package allexamples;

import leetcodeeasy.binaryTree.TreeNode;

public class BinaryFromArray {


    public static TreeNode buildSameOrderTree(TreeNode root, int[] arr, int i) {

        if (i < arr.length) {
            TreeNode tmp = new TreeNode(arr[i]);
            root = tmp;


            // insert left child
            System.out.println((2 * i + 1) + "=====" + (2 * i + 2));
            root.left = buildSameOrderTree(root.left, arr,
                    2 * i + 1);

            // insert right child
            root.right = buildSameOrderTree(root.right, arr,
                    2 * i + 2);
        }

        return root;
    }


    public static TreeNode buildBalancedTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildBalancedTree(arr, start, mid - 1);
        node.right = buildBalancedTree(arr, mid + 1, end);
        return node;
    }




    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("+++" + root.val);
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        t2 = buildSameOrderTree(t2, arr, 0);
        //  inOrder(t2);

        TreeNode tree = buildBalancedTree(arr, 0, arr.length - 1);
        inOrder(tree);

    }
}
