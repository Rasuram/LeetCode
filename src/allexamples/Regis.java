package allexamples;/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named allexamples.Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

class Solution {


    public String getMatchingPrefix(String[] words) {
        int pointer = 0;
        String result=" ";
        String word = words[0];
        char[] chArry = word.toCharArray();

        for (char c : chArry) {
            if (isMatch(words, pointer, c)) {
                pointer++;
                result+=c;
            }

        }
        return result;
    }

    public boolean isMatch(String[] words, int pointer, char c) {
        for (int j = 1; j < words.length; j++) {
            if (words[j].charAt(pointer) == c) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String[] str = {"flower", "flow", "flight"};
        String[] str1 ={"dog","racecar","car"};

        Solution s = new Solution();
        System.out.println(s.getMatchingPrefix(str1));


    }
}

