package allexamples;

import java.util.Arrays;

public class Anagram {


    public static void main(String[] args) {

        String first = "LISTEN";
        String second = "SILENT";
        char ch[] = first.toCharArray();
        char ch1[] = second.toCharArray();

        Arrays.sort(ch);
        Arrays.sort(ch1);
        System.out.println(new String(ch).equals(new String(ch1)));

    }
}
