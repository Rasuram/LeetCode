package leetcodeeasy;

/*
* Given two strings A and B of lowercase letters,
* return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping
* the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
*
* "abcd" results in "cbad".
* Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuddyStrings {

    static List<String> possibleStrings = new ArrayList<>();
    static List<Integer> swappedChars = new ArrayList<>();

    public static boolean matchingStrings(String A, String B) {
     printPermutn(A, B, 0, "");
     return false;

    }


    // Function to print all the permutations of str
    static void printPermutn(String A, String B, int size, String ans) {

        if (possibleStrings.contains(B)) {
            return;
        }

        // If string is empty
        if (A.length() == 0) {
            possibleStrings.add(ans);
        }

        for (int i = 0; i < A.length(); i++) {

            // ith character of str
            char ch = A.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = A.substring(0, i) +
                    A.substring(i + 1);

            // Recurvise call
            printPermutn(ros, B, size + 1, ans + ch);
        }

    }

    public static boolean buddyStrings(String A, String B) {

        if (A == null || B == null || A.isEmpty() || B.isEmpty() || A.length() != B.length()) {
            return false;
        }
        char[] aCharArray = A.toCharArray();
        char[] bCharArray = B.toCharArray();
        if (A.equals(B) && A.charAt(0) != A.charAt(1)) {
            HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
            for (int i = 0; i < aCharArray.length; i++) {
                if (hm.get(aCharArray[i]) == null) {
                    hm.put(aCharArray[i], i);
                } else {
                    return true;
                }
            }
        }

        List<Integer> swapIndex = new ArrayList<Integer>();
        for (int i = 0; i < aCharArray.length; i++) {
            if (aCharArray[i] != bCharArray[i]) {
                swapIndex.add(i);
                if (swapIndex.size() == 2) {
                    //swap the letters, check to be equal, return
                    char swappedChar = bCharArray[(int) swapIndex.get(0)];
                    bCharArray[(int) swapIndex.get(0)] = bCharArray[(int) swapIndex.get(1)];
                    bCharArray[(int) swapIndex.get(1)] = swappedChar;
                    return new String(aCharArray).equals(new String(bCharArray));

                }
            }
        }
        return false;
    }


    public static void main(String[] args) {


        // System.out.println(buddyStrings("aaaaaaabc","aaaaaaacb"));
        // System.out.println(buddyStrings("abcd", "cbad"));
        //  System.out.println(buddyStrings("ab", "ba"));
        //  System.out.println(buddyStrings("ab", "ab"));
        //  System.out.println(buddyStrings("aa", "aa"));
        System.out.println(matchingStrings("cabbba", "abbccc"));
    }
}
