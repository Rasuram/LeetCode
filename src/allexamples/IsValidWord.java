package allexamples;

public class IsValidWord {

    public static boolean isValidWord(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            if (Character.isLowerCase(word.charAt(1))) {
                return isLower(word.substring(1), 0);
            } else {
                return isUpper(word.substring(1), 0);
            }
        } else {
            return isLower(word.substring(1), 0);
        }
    }

    public static boolean isLower(String str, int index) {
        if (str.length() == index) {
            return true;
        }
        if (!Character.isLowerCase(str.charAt(index))) {
            return false;
        }
        return isLower(str, index + 1);
    }

    public static boolean isUpper(String str, int index) {
        if (str.length() == index) {
            return true;
        }
        if (!Character.isUpperCase(str.charAt(index))) {
            return false;
        }
        return isUpper(str, index + 1);
    }


    public static void main(String[] args) {
        System.out.println(isValidWord("USA"));
        System.out.println(isValidWord("Usa"));
        System.out.println(isValidWord("usa"));

        System.out.println(isValidWord("uAa"));
    }
}
