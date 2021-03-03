package BSTExample;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeWithoutRecursion {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }


    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root,list);
        return list;
    }
    void inOrder(Node root,List<Integer> list){

        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.data);
        inOrder(root.right,list);
    }

    void inorder(Node root){
        Stack<Node> s = new Stack<>();
        Node curr = root;
        if(root==null){
            return;
        }
        while (curr!=null || s.size()>0){

            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
            /* Current must be NULL at this point */
            curr = s.pop();
            System.out.print(curr.data + " ");
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }

    }

    public static void main(String args[]) {

        /* creating a binary tree and entering
        the nodes */
        BinaryTreeWithoutRecursion tree = new BinaryTreeWithoutRecursion();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        // without recursion
        tree.inorder(root);
        //with recursion
        tree.inorderTraversal(root);
    }

}
