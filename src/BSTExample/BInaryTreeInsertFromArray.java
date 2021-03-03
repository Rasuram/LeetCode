package BSTExample;

public class BInaryTreeInsertFromArray {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BInaryTreeInsertFromArray() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty,
           return a new node */
            if (root == null) {
                root = new Node(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            if ( (key-root.key)==(root.key*root.key))
                root.left = insertRec(root.left, key);
            else
                root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);

            inorderRec(root.right);
        }
    }

    static int findMax(int a, int b) {
        if (a >= b)
            return a;
        else
            return b;
    }

    static int findHeight(Node root) {
        // Base case:
        if (root == null)
            return 0;

        return findMax(findHeight(root.left), findHeight(root.right)) + 1;
    }

    static int maxLen;
    static int maxSum;

    // function to find the sum of nodes on the
    // longest path from root to leaf node
    static void sumOfLongRootToLeafPath(Node root, int sum,
                                        int len) {
        // if true, then we have traversed a
        // root to leaf path
        if (root == null) {
            // update maximum length and maximum sum
            // according to the given conditions
            if (maxLen < len) {
                maxLen = len;
                maxSum = sum;
            } else if (maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }


        // recur for left subtree
        sumOfLongRootToLeafPath(root.left, sum + root.key,
                len + 1);

        sumOfLongRootToLeafPath(root.right, sum + root.key,
                len + 1);

    }

    // utility function to find the sum of nodes on
    // the longest path from root to leaf node
    static int sumOfLongRootToLeafPathUtil(Node root) {
        // if tree is NULL, then sum is 0
        if (root == null)
            return 0;

        maxSum = Integer.MIN_VALUE;
        maxLen = 0;

        // finding the maximum sum 'maxSum' for the
        // maximum length root to leaf path
        sumOfLongRootToLeafPath(root, 0, 0);

        // required maximum sum
        return maxSum;
    }


    // Driver Code
    public static void main(String[] args) {
        BInaryTreeInsertFromArray tree = new BInaryTreeInsertFromArray();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        long[] arr = new long[]{1, 2, 3, 4, -1, -1, -1};
        for (int i = 0; i < arr.length; i++) {
            tree.insert((int) arr[i]);
        }

        // print inorder traversal of the BST
        tree.inorder();
        System.out.println(sumOfLongRootToLeafPathUtil(tree.root));
    }
}
