public class Permutations {

    /*
     *
     * https://www.techiedelight.com/generate-permutations-string-java-recursive-iterative/
     * */
    public static void printPermutations(char[] ch, int currentIndex) {

        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
            return;
        }
        for (int i = currentIndex; i < ch.length; i++) {
            swap(ch, currentIndex, i);
            printPermutations(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }


    public static void printPermutationsIterative(String candidate, String remaining) {

        if (remaining.length() == 0) {
            System.out.println(candidate);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            String newCan = candidate + remaining.charAt(i);
            String newRemain = remaining.substring(0, i) + remaining.substring(i + 1);
            printPermutationsIterative(newCan, newRemain);
        }
    }


    public static void main(String[] args) {
       // printPermutations("ABC".toCharArray(), 0);
        printPermutationsIterative("","ABC");
    }
}
