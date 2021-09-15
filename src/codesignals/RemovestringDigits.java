package codesignals;

public class RemovestringDigits {


    static int removeOneDigit(String s, String t) {

        // StringBuffer sb = new StringBuffer(s);
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                boolean isSmaller = isSmaller(new StringBuilder(s).deleteCharAt(i).toString(), t);
                if (isSmaller) {
                    counter++;
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (Character.isDigit(t.charAt(i))) {
                boolean isSmaller = isSmaller(s, new StringBuilder(t).deleteCharAt(i).toString());
                if (isSmaller) {
                    counter++;
                }
            }
        }

        return counter;

    }


    static String mergeStrings(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        String small = s1.length() > s2.length() ? s2 : s1;
        for (int i = 0; i < small.length() - 1; i++) {
            if (s1.length() - 1 > i) {
                sb.append(s1.charAt(i));
            }
            if (s2.length() - 1 > i) {
                sb.append(s2.charAt(i));
            }

        }
        String s = s1.length() > s2.length() ? s2.substring(s1.length() - 1) : s1.substring(s1.length() - 1);
        sb.append(s);
        return sb.toString();
    }




    public static boolean isSmaller(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            int left = Character.isDigit(s.charAt(i)) ? s.charAt(i) : (s.charAt(i) - 96);
            int right = Character.isDigit(t.charAt(i)) ? t.charAt(i) : (t.charAt(i) - 96);
            if (left > right) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //= "ab12c" and t = "1zz456", the output should be removeOneDigit(s, t) = 1.
        System.out.println(removeOneDigit("ab12c", "ab24z"));
        System.out.println(mergeStrings("dce","cccbd"));
    }

}
