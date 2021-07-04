package BSTExample;

import leetcodeeasy.binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {


    public void levelOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            for (int i = 0; i < q.size(); i++) {

                TreeNode child = q.poll();
                System.out.println(child.val);
                if (child.left != null) {
                    q.add(child.left);
                }
                if (child.right != null) {
                    q.add(child.right);
                }
            }
        }

        // levelOrderTraversal(root.left);
        // levelOrderTraversal(root.right);
        //  System.out.println(root.val);
    }

    public boolean isBalanced(TreeNode root, TreeNode l, TreeNode r) {

        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.val <= l.val)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.val >= r.val)
            return false;

        // check recursively for every node.
        return isBalanced(root.left, l, root) &&
                isBalanced(root.right, root, r);
    }


    public static int howmany(String s){
        String[] sarray = s.split(" ");
        int wordCount=0;
        for(String str : sarray){
            if(!str.isEmpty() && Character.isLetter(str.charAt(0)) && !str.contains("[") &&
                    !str.matches(".*\\d.*")){
                wordCount++;
            }
        }
        return wordCount;
    }


    public static void main(String[] args) {
        LevelOrderTraversal l = new LevelOrderTraversal();
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right = new TreeNode(200);
        root.right.left = new TreeNode(90);
        root.right.right = new TreeNode(350);
        l.levelOrderTraversal(root);
        //System.out.println(l.isBalanced(root, null, null));

        System.out.println(howmany("jds dsaf lkdsa kdsa dddd, ddd ddd ddd? dd dd dd dd[l. dd dd dd 879  dwa we de 7666 dsss ds rrr 748 dj."));

    }
}
