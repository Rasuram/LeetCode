package allexamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
* */


public class WordBreak {

    Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    /*public void isMatch(String s, int start, int end, List<String> wordDict) {
        if (end <= s.length()) {
            String sub = s.substring(start, end);
            if (wordDict.contains(sub)) {
                output += sub;
                set.add(sub);
                isMatch(s, end, end + 1, wordDict);
            } else {
                isMatch(s, start, end + 1, wordDict);

            }
        }
    }
*/

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wb.wordBreak("catsandog", wordDict));
    }
}
