package BSTExample;

import javax.swing.tree.TreeNode;

public class BSTExample {

    static class Node {
        int data;
        Node left;
        Node right;

    }


    static class BST {

        public Node createNewNode(int k) {
            Node n = new Node();
            n.data = k;
            n.left = null;
            n.right = null;
            return n;
        }

        public Node insert(Node n, int value) {
            if (n == null) {
                return createNewNode(value);
            }
            if (value < n.data) {
                n.left = insert(n.left, value);
            } else if (value > n.data) {
                n.right = insert(n.right, value);
            }
            return n;
        }


        public Node findMinElement(Node root) {
            if (root == null) {
                return null;
            }
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        public int findMaxElement(Node root) {

            if (root == null) {
                return -1;
            }
            while (root.right != null) {
                root = root.right;
            }
            return root.data;
        }

        Node deleteGivenNode(Node delete) {

            if (delete.left == null || delete.right == null) {
                delete = null;
            }
            return delete;
        }

        // Helper function to find maximum value node in subtree rooted at ptr
        public static Node maximumKey(Node ptr) {
            while (ptr.right != null) {
                ptr = ptr.right;
            }
            return ptr;
        }


        public Node deleteNode(Node root, int key) {
            /* Base Case: If the tree is empty */
            if (root == null)
                return root;

            /* Otherwise, recur down the tree */
            if (key < root.data)
                root.left = deleteNode(root.left, key);
            else if (key > root.data)
                root.right = deleteNode(root.right, key);

                // if key is same as root's
                // key, then This is the
                // node to be deleted
            else {
                // node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                root.data = minValue(root.right);

                // Delete the inorder successor
                root.right = deleteNode(root.right, root.data);
            }

            return root;
        }

        int minValue(Node root)
        {
            int minv = root.data;
            while (root.left != null)
            {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }

        Node findNode(Node rootNode, int data) {
            if (rootNode == null) {
                return null;
            }
            if (data == rootNode.data) {
                return rootNode;
            } else if (data > rootNode.data) {
                return findNode(rootNode.right, data);
            } else {
                return findNode(rootNode.left, data);
            }
        }

        Node findInorderSuccessor(Node rootNode, int data) {

            Node currentNode = findNode(rootNode, data);
            if (currentNode == null) {
                return null;
            }
            if (currentNode.right != null) {
                return findMinElement(currentNode.right);
            }
            return currentNode;
        }

        static int max_level = 0;
        int counter = 0;
        long[] l = new long[10];

        long[] leftSubTreeValues(Node root) {
            leftViewUtil(root, 0);
            long[] newItems = new long[counter];
            System.arraycopy(l, 0, newItems, 0, counter);
            l = newItems;
            return l;
        }

        void leftViewUtil(Node node, int level) {
            if (node == null) {
                return;
            }
            if (max_level < level) {
                l[counter] = node.data;
                counter++;
                max_level = level;
            }
            //swap below two lines get the order, if first node.left meaning you will get all your left nodes
            //if it fist node.right, you will get all right nodes
            leftViewUtil(node.left, level + 1);
            leftViewUtil(node.right, level + 1);
        }
    }


    public static void main(String[] args) {

        BST b = new BST();
        Node root = null;
        //8,3,6,10,4,7,1,14,13
        /*for delete input */
       // [5,3,6,2,4,null,7]
       // 3

        root = b.insert(root, 50);
        root = b.insert(root, 30);
        root = b.insert(root, 20);
        root = b.insert(root, 40);
        root = b.insert(root, 70);
        root = b.insert(root, 80);
        root = b.insert(root, 60);
        /*root = b.insert(root, 14);
        root = b.insert(root, 9);
        root = b.insert(root, 13);*/
        System.out.println(root);
        System.out.println(b.findMinElement(root));
        System.out.println(b.findMaxElement(root));

        System.out.println(b.findNode(root, 6));
        Node successor = b.findInorderSuccessor(root, 60);
        System.out.println(successor);


        long[] leftArray = b.leftSubTreeValues(root);
        System.out.println(leftArray);

         /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        b.deleteNode(root,20);
        System.out.println(root);


    }
}
