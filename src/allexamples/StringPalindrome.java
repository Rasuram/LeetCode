package allexamples;

public class StringPalindrome {


    public static boolean isPal(String str) {


        if (str.length() == 0 || str.length() == 1) return true;

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPal(str.substring(1, str.length() - 1));
        }
        return false;

    }


    public static void main(String[] args) {


        System.out.println(isPal("aaa"));
    }
}
