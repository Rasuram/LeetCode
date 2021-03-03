package leetcodeeasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
*
* */
public class MaximumDepthNaryTree {

    int max_depth = 0;

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }

        List<Node> nodeList = root.children;
        int depth = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                if (current != null && current.children != null) {
                    for (Node child : current.children) {
                        q.offer(child);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        DFS(root, 1);
        return max_depth;
    }

    public void DFS(Node root, int max) {

        if (root == null) {
            return;
        }
        max_depth = Math.max(max, max_depth);
        if (root.children != null) {
            for (Node children : root.children) {
                DFS(children, max + 1);
            }
        }
    }


    public static void main(String[] args) {


        List<Node> l2 = new ArrayList<>();
        Node children4 = new Node(2);
        Node children5 = new Node(4);
        l2.add(children4);
        l2.add(children5);

        Node children3 = new Node(3, l2);

        List<Node> l = new ArrayList<>();
        Node children = new Node(2);
        Node children2 = new Node(4);
        l.add(children);
        l.add(children2);
        l.add(children3);

        Node root = new Node(1, l);

        MaximumDepthNaryTree m = new MaximumDepthNaryTree();
        System.out.println(m.maxDepth(root));
        // System.out.println(m.maxDepth1(root));


    }
}
