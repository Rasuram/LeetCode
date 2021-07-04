package allexamples;

import java.util.*;

/*

You are running a classroom and suspect that some of your students are passing around the answers to multiple choice questions disguised as random strings.

Your task is to write a function that, given a list of words and a string, finds and returns the word in the list that is scrambled up inside the string, if any exists. There will be at most one matching word. The letters don't need to be contiguous.

Example:
words = ['cat', 'baby', 'dog', 'bird', 'car', 'ax']
string1 = 'tcabnihjs'
find_embedded_word(words, string1) -> cat

string2 = 'tbcanihjs'
find_embedded_word(words, string2) -> cat

string3 = 'baykkjl'
find_embedded_word(words, string3) -> None / null

string4 = 'bbabylkkj'
find_embedded_word(words, string4) -> baby

string5 = 'ccc'
find_embedded_word(words, string5) -> None / null

string6 = 'breadmaking'
find_embedded_word(words, string6) -> bird

W = number of words in `words`
L = maximal string length of each word

*/
public class HIddenWord {


    public static String getHidden(String[] words, String input) {

        //baykkjl
        //["baby", "dog", "bird", "car", "ax"]
        String result = null;


        for (String st : words) {
            char[] ch = st.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < input.length(); i++) {
                if (map.containsKey(input.charAt(i))) {
                    map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
                } else {
                    map.put(input.charAt(i), 1);
                }
            }
            for (int i = 0; i < ch.length; i++) {
                int index = input.indexOf(ch[i]);
                if (index >= 0 && map.get(ch[i]) > 0) {
                    if (i == ch.length - 1) {
                        result = st;
                    }
                    map.put(ch[i], map.get(ch[i]) - 1);
                } else {
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] argv) {
        String[] words = new String[]{"cat", "baby", "dog", "bird", "car", "ax"};
        String string1 = "tcabnihjs";
        String string2 = "tbcanihjs";
        String string3 = "baykkjl";
        String string4 = "bbabylkkj";
        String string5 = "ccc";
        String string6 = "breadmaking";

        System.out.println(getHidden(words, string1));
        System.out.println(getHidden(words, string2));
        System.out.println(getHidden(words, string3));
        System.out.println(getHidden(words, string4));
        System.out.println(getHidden(words, string5));
        System.out.println(getHidden(words, string6));
        // TODO --- Call your function with the test cases from above
    }
    // TODO --- Write your function
}

