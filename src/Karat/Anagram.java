package Karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a list of words = [‘LOOPED’, ‘ALLERGY’, ‘GALLERY’, ‘LARGELY’, ‘POODLE’, ‘CARROT’],
return a list of distinct and complete sets of anagrams.
Anagrams are words that use the same letters with the exact same number of occurrences.
 For the previous example, the expected output would be [[‘LOOPED’, ‘POODLE’], [‘ALLERGY’, ‘GALLERY’, ‘LARGELY’]].
 The sets returned should each have at least two words in them*/
public class Anagram {

    void listOfAnagrams(String[] arr) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<String> list1 = new ArrayList<>();
            list1.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (isMatch(arr[i], arr[j])) {
                    list1.add(arr[j]);
                }
            }
            list.add(list1);
        }
        System.out.println(list);
    }

    boolean isMatch(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return new String(ch1).equals(new String(ch2));
    }


    public static void main(String[] args) {
        String[] str = {"LOOPED", "ALLERGY", "GALLERY", "LARGELY", "POODLE", "CARROT"};
        Anagram a = new Anagram();
        a.listOfAnagrams(str);
    }
}
