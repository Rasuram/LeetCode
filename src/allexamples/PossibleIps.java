package allexamples;

import java.util.ArrayList;
import java.util.List;

public class PossibleIps {

    public static List<String> restoreIpAddresses(String s) {

        if (s.length() < 3 || s.length() > 12) {
            return new ArrayList<>();
        }


        return convert(s);
    }

    public static List<String> convert(String s) {
        int n = s.length();
        List<String> possible = new ArrayList<>();
        for (int i = 1; i < n && i < 4; i++) {
            String first = s.substring(0, i);
            if (isNotValidPart(first)) {
                continue;
            }
            for (int j = 1; i + j < n && j < 4; j++) {
                String second = s.substring(i, i + j);
                if (isNotValidPart(second)) {
                    continue;
                }
                for (int k = 1; i + j + k < n && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);
                    if (isNotValidPart(third) || isNotValidPart(fourth)) {
                        continue;
                    }
                    possible.add(first + "." + second + "." + third + "." + fourth);
                }
            }


        }
        return possible;
    }

    private static boolean isNotValidPart(String st) {
        if (st.length() > 3) {
            return true;
        }
        if (st.startsWith("0") && st.length() > 1) {
            return true;
        }
        int v = Integer.parseInt(st);
        return !(v >= 0 && v <= 255);
    }


    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
