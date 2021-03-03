package BSTExample;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    class Node {
        long data;
        Node left;
        Node right;

        Node(long d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class Sum {
        long leftSum;
        long rightSum;
    }

    public Node insertNode(Node root, long value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value > 0 && value > root.data) {
            root.left = insertNode(root.left, value);
        } else if (value > 0 && value < root.data) {
            root.right = insertNode(root.right, value);
        }
        return root;

    }

    public static String solution(long[] arr) {
        // Type your solution here
        Node root = null;
        Solution s = new Solution();
        for (long l : arr) {
            root = s.insertNode(root, l);

        }
        Sum sum = new Sum();
        traverse(root, sum);

        return sum.leftSum > sum.rightSum ? "Left" : "Right";
    }

    private static void traverse(Node root, Sum sum) {

        if (root != null) {
            if (root.left != null && root.left.data != -1) {
                sum.leftSum = sum.leftSum + root.left.data;
                traverse(root.left, sum);
            }
            if (root.right != null && root.right.data != -1) {
                sum.rightSum = sum.rightSum + root.right.data;
                traverse(root.right, sum);
            }
        }
    }

    public static void main(String[] args) {


        char ch = 'h';
        //int pos = ch - 'a' + 1;
        //System.out.println(pos);
        String str = "";
        String word = "helloworld";
        String cipher = "bjosxcqukmrhgeynazlwfpvti";

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int pos = c-'a';

            str+=cipher.charAt(pos);

        }
    }


    private static class Entry implements Comparable<Entry> {
        int val, r, c, init;

        Entry(int val, int r, int c, int init) {
            this.val = val;
            this.r = r;
            this.c = c;
            this.init = init;
        }

        public int compareTo(Entry that) {
            return Integer.compare(that.val, this.val);
        }
    }
}

