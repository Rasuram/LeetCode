package allexamples;

import java.util.HashMap;
import java.util.Map;

public class GemStone {

    static int gemstones(String[] arr) {
        int counter = 0;
        Map<Character, Boolean> isFound = new HashMap<>();
        if (arr.length > 0) {

            for (int j = 0; j < arr[0].length(); j++) {
                char c = arr[0].charAt(j);
                if (!isFound.containsKey(c)) {
                    boolean match = false;
                    for (int i = 1; i < arr.length; i++) {
                        String st = arr[i];
                        if (st.indexOf(c) < 0) {
                            isFound.put(c, false);
                            match = false;
                            break;
                        }
                        isFound.put(c, true);
                        match = true;
                    }
                    if (match) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String[] str = {"abcdde", "baccd", "eeabg"};
        System.out.println(gemstones(str));
    }

}
