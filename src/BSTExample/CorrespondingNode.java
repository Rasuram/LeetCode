package BSTExample;

public class CorrespondingNode {
    TreeNode ans, target;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.val = data;
        }

    }

    public TreeNode insert(TreeNode n, int value) {
        if (n == null) {
            return new TreeNode(value);
        }
        if (value < n.val) {
            n.left = insert(n.left, value);
        } else if (value > n.val) {
            n.right = insert(n.right, value);
        }
        return n;
    }

    public void inorder(TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o.val == target.val) {
                ans = c;
            }
            inorder(o.right, c.right);
        }
    }


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }

    public static void main(String[] args) {

        CorrespondingNode b = new CorrespondingNode();
        //8,3,6,10,4,7,1,14,13
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);


        TreeNode result = b.getTargetCopy(root, root, new TreeNode(3));
        System.out.println(result);
    }
}
