package DailyCodingProblems;

/*
 *
 * For example, given the query string 'de' and the set of strings [dog, deer, deal], return [deer, deal].
 * */

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteStrings {


    List<String> getRelevantStrings(String[] arr, String search) {

        List<String> l = new ArrayList<>();
        for (String s : arr) {
            boolean isMatch = recursiveSearch(s, search, 0);
            if (isMatch) {
                l.add(s);
            }
        }

        return l;
    }


    boolean recursiveSearch(String input, String result, int i) {



        if(input.charAt(i) != result.charAt(i)){
            return false;
        }
        if (result.length() - 1 == i) {
            return true;
        }
        if (input.length() <= result.length()) {
            return false;
        }


        return recursiveSearch(input, result, ++i);
    }


    public static void main(String[] args) {
        AutoCompleteStrings a = new AutoCompleteStrings();
        String[] strings = {"dog", "deer", "deal"};
        System.out.println(a.getRelevantStrings(strings, "dea").toString());
    }
}
