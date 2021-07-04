package allexamples;/*
*
-sub domain visit count (leetcode)
-longest common subsequence (leetcode)

*
* One question involved checking whether a given three digit tuple contained either a prime number, or a power of primes.

* Find the area of a rectangle based on grid array
*
* How to implement hashing?
*
* Knapsack problem
max subarray sum
*
*
 */


import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WayFair {


    void longestSubSequence() {
        String s1 = "abdace";
        String s2 = "babce";
        int index = 0;
        String str = "";
        String backup = "";
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s2.charAt(i) == s1.charAt(j) && j >= index) {
                    index = j;
                    str += s2.charAt(i);
                    break;
                }
            }
            if (str.length() > backup.length()) {
                backup = str;
            }
        }
        System.out.println(backup);
    }


    /*
    time complexity o(n2)
    space complexity
    The second question involved finding the longest consecutive subsequence for an arbitrary number of lists.
    */
    void findLongestConsecutiveSubsequence() {
        int[] arr = {0, 1, 0, 3, 2, 3};
        int counter = 0;
        int backup = 0;
        int maxlength = 0;
        for (int i = 0; i < arr.length; i++) {
            counter = 0;
            backup = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j] && backup <= arr[j]) {
                    counter++;
                    backup = arr[j];
                }
            }
            if (counter > maxlength) {
                maxlength = counter;
            }
        }
        System.out.println(maxlength);
    }

    // Function to find the length of largest subsequence formed by consecutive integers, irrespective of orders
    //time complexity O(N)
    //Auxiliary space O(N)
    public int findMaxLenSubSeq() {
        // construct a set out of input elements
        int[] arr = {2, 0, 6, 1, 5, 3, 7};
        Set<Integer> S = IntStream.of(arr)      // returns IntStream
                .boxed()
                .collect(Collectors.toSet());

        // initialize result by 1
        int maxLen = 1;

        // do for each element of the input sequence
        for (int e : arr) {
            // check if current element e is candidate for starting of a sequence
            // i.e. previous element (e - 1) don't exist in the set
            // len stores the length of subsequence starting with current element
            int len = 1;

            // check for presence of elements e+1, e+2, e+3.. e+len in the set
            while (S.contains(e + len)) {
                len++;
            }

            // update the result with the length of current consecutive subsequence
            maxLen = Math.max(maxLen, len);
        }

        // return result
        return maxLen;
    }


    void findDigitsSumInString() {
        String s1 = "test2check4he8llo";
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isDigit(c)) {
                num += c - '0';
            }
        }
        System.out.println("digit sum is ====>" + num);

        Matcher matcher = Pattern.compile("\\d+").matcher(s1);
        String str = "";
        while (matcher.find()) {
            str = matcher.group();
            System.out.print(str);
        }
    }


    void matchingBrackets() {
        String str = "( ( { ( { [ ] } ) } ) )".trim();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
                continue;
            }
            if (s.isEmpty())
                System.out.println("empty not balanced");
            char check;
            switch (c) {
                case ')':
                    check = s.pop();
                    if (check == ']' || check == '}') {
                        System.out.println("not balanced!");
                    }
                    break;
                case '}':
                    check = s.pop();
                    if (check == ']' || check == ')') {
                        System.out.println("not balanced!");
                    }
                    break;
                case ']':
                    check = s.pop();
                    if (check == '}' || check == ')') {
                        System.out.println("not balanced!");
                    }
                    break;
            }

        }
        System.out.println(s.isEmpty());
    }


    // Function to find the maximum
    // length of equal subarray
    static int FindMaxLength(int A[], int B[], int n, int m) {

        // Auxillary dp[][] array
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = 0;

        // Updating the dp[][] table
        // in Bottom Up approach
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // If A[i] is equal to B[i]
                // then dp[i][j]= dp[i + 1][j + 1]+1
                if (A[i] == B[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
            }
        }
        int maxm = 0;

        // Find maximum of all the values
        // in dp[][] array to get the
        // maximum length
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Update the length
                maxm = Math.max(maxm, dp[i][j]);
            }
        }

        // Return the maximum length
        return maxm;
    }


    static int LongestIncreasingSubsequenceLength(int v[]) {
        if (v.length == 0) // boundry case
            return 0;

        int[] tail = new int[v.length];
        int length = 1; // always points empty slot in tail
        tail[0] = v[0];

        for (int i = 1; i < v.length; i++) {

            if (v[i] > tail[length - 1]) {
                // v[i] extends the largest subsequence
                tail[length++] = v[i];
            } else {
                // v[i] will extend a subsequence and
                // discard older subsequence

                // find the largest value just smaller than
                // v[i] in tail

                // to find that value do binary search for
                // the v[i] i                                                        n the range from begin to 0 +
                // length
                int idx = Arrays.binarySearch(
                        tail, 0, length - 1, v[i]);

                // binarySearch in java returns negative
                // value if searched element is not found in
                // array

                // this negative value stores the
                // appropriate place where the element is
                // supposed to be stored
                if (idx < 0)
                    idx = -1 * idx - 1;

                // replacing the existing subsequene with
                // new end value
                tail[idx] = v[i];
            }
        }
        return length;
    }

    // -Find longest matching contiguous elements in 2 arrays.
    void longestContiguous() {
        int[] arr1 = {1, 2, 3, 5, 8, 3, 1, 6};
        int[] arr2 = {5, 1, 2, 3, 8, 3, 2, 6};
        System.out.println(FindMaxLength(arr1, arr2, arr1.length, arr2.length));
        boolean chaincontinue = false;
        StringBuilder sb = new StringBuilder();
        String temp = "";
        for (int i = 0; i < arr1.length; i++) {
            if (chaincontinue && temp.length() < sb.length()) {
                temp = sb.toString();
            } else {
                sb = new StringBuilder();
            }
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (i > 0 && j > 0) {
                        int prv1 = arr1[i - 1];
                        int prv2 = arr2[j - 1];
                        if (prv1 == prv2) {
                            sb.append(arr1[i]);
                            sb.append("-->");
                        }
                    }
                    chaincontinue = true;
                    break;
                } else {
                    chaincontinue = false;
                }
            }
        }
        System.out.println(sb.toString());
        System.out.println(temp);
    }

    //* a1 -> b1 -> c1 -> c2 . -- your function should return true.
    //a1 -> c1 -- return true
    //a1 -> b2 -- return false.
    void calc() {
        String s = "a1 -> b1 -> c1 -> c2";

        String[] arr = s.split("->");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].trim().split("")[1].equals(arr[i - 1].trim().split("")[1])) {
                System.out.println("both are equals!" + arr[i] + arr[i - 1]);
            } else {
                System.out.println("both are not equals!" + arr[i] + arr[i - 1]);
            }
        }
    }


    //generate palindrome using recursion
    int generatePalindromeRecursion(int n, int temp) {

        // base case
        if (n == 0)
            return temp;

        // stores the reverse
        // of a number
        temp = (temp * 10) + (n % 10);
        return generatePalindromeRecursion(n / 10, temp);
    }

    boolean generatePalindromeRecursion(String n) {

        // base case
        if (n.length() == 0 || n.length() == 1)
            return true;

        if (n.charAt(0) == n.charAt(n.length() - 1)) {
            return generatePalindromeRecursion(n.substring(1, n.length() - 1));
        }
        return false;
    }


    void twoStringsIsomorphic() {
        // isomorphic("ABC", "XYZ"); //true
        //  isomorphic("ABCCBA", "XYZZYX"); //true
        //isomorphic("ABCABC", "XYXXYX"); // false
        String s1 = "ABC";
        String s2 = "XYZ";
        int n = s1.length() - 1;
        if (s1.length() != s2.length()) {
            System.out.println("not isoMorphic");
        }


        for (int i = 0; i < n; i++) {
            int nu = s1.charAt(i);
            int nu1 = s2.charAt(n - i);

            if (nu + (25 - i) != nu1) {
                System.out.println("not isoMorphic");
                break;
            }
        }
    }


    void possiblePairs() {
        //acf
        //acg
        char[][] arrays = new char[][]{
                {'a', 'b'},
                {'c', 'd', 'e'},
                {'f', 'g'}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    System.out.println(arrays[0][i] + "" + arrays[1][j] + arrays[2][k]);
                }
            }
        }


    }

    public static void main(String[] args) {
/*        WayFair wayFair = new WayFair();
        System.out.println(wayFair.generatePalindromeRecursion(121, 0));
        System.out.println(wayFair.generatePalindromeRecursion("1221"));
        //possible pairs
        wayFair.possiblePairs();
        wayFair.twoStringsIsomorphic();
        wayFair.calc();
        wayFair.longestContiguous();
        wayFair.matchingBrackets();
        wayFair.findDigitsSumInString();
        wayFair.findLongestConsecutiveSubsequence




        ();
        wayFair.longestSubSequence();
        //any order
        wayFair.findMaxLenSubSeq();*/

        int v[] = {10,9,2,5,3,5,7,101,103,8,18,20,21} ;
        System.out.println(
                "Length of Longest Increasing Subsequence is "
                        + LongestIncreasingSubsequenceLength(v));
    }
}
