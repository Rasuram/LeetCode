package allexamples;

public class LongestSubString {


    private static String getSubString(String s) {
        StringBuilder temp = new StringBuilder();
        String finalString = "";

        for (int i = 1; i < s.length(); i++) {
            char next = s.charAt(i);
            char current = s.charAt(i - 1);
            if ((char) (current + 1) == next) {
                if (temp.length() == 0) {
                    temp.append(current);
                }
                temp.append(next);
            } else {

                temp = new StringBuilder();
            }
            if (temp.length() > finalString.length()) {
                finalString = temp.toString();
            }
        }
        return finalString;
    }

    private static int getLongest(String s) {
        int max = 0;
        String current_string = "";
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int pos = current_string.indexOf(c);
            if (pos != -1) {
                current_string = current_string.substring(pos + 1);
            }
            current_string += c;
            max = Math.max(max, current_string.length());
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(getSubString("abcabcbb"));
        System.out.println(getLongest("abcabcbb"));
    }
}
