package google;

public class FindOccurrences {

    public static int findOccurrence(String bigString, String smallString) {

        int left = 0;
        int counter = 0;
        int length = smallString.length();
        while (true) {
            String sub = bigString.substring(left, left + length);
            boolean isMatch = false;
            for (int i = 0; i < sub.length(); i++) {
                if (sub.contains(String.valueOf(smallString.charAt(i)))) {
                    isMatch = true;
                } else {
                    isMatch = false;
                    break;
                }
            }
            left++;
            if (isMatch) {
                counter++;
            }
            if (left > bigString.length() - length) {
                break;
            }
        }
        return counter;

    }


    public static void main(String[] args) {
        System.out.println(findOccurrence("cbabcacabca", "abc"));
    }

}
