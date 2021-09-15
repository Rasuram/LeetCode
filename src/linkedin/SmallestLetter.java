package linkedin;

import java.util.HashSet;
import java.util.Set;

public class SmallestLetter {


    public static char nextGreatestLetter(char[] letters, char target) {

        int diff = Integer.MAX_VALUE;
        char result = ' ';
        for (char c : letters) {

            if (target == 'z') {
                return 'a';
            }

            if (c > target) {

                if (c - target < diff) {
                    diff = c - target;
                    result = c;
                }

            }

        }
        return result;
    }


    public void solution(String stringValue) {
        var maximumValue = Integer.MIN_VALUE;
        for (int index = 0; index < stringValue.length(); index++) {
            int testValue = Integer.parseInt(stringValue.substring(0, index) + 5 + stringValue.substring(index));
            if (maximumValue < testValue)
                maximumValue = testValue;
        }
        System.out.println(maximumValue);
    }



    public static void main(String[] args) {
        char[] ch = {'a', 'b'};
        System.out.println(nextGreatestLetter(ch, 'z'));

        char[] ch1 = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(ch1, 'c'));

        // Creating object of Set
        Set<String> arrset1 = new HashSet<String>();

        // Populating arrset1
        arrset1.add("A");
        arrset1.add("B");
        arrset1.add("C");
        arrset1.add("D");
        arrset1.add("E");

        // print arrset1
        System.out.println("First Set: "
                + arrset1);

        // Creating another object of Set
        Set<String> arrset2 = new HashSet<String>();

        // Populating arrset2
        arrset2.add("a");
        arrset2.add("B");
        arrset2.add("C");
        arrset2.add("D");
        arrset2.add("E");
        System.out.println(arrset1.equals(arrset2));

    }
}
