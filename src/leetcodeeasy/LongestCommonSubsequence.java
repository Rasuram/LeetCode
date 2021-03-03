package leetcodeeasy;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] charARray = text2.toCharArray();
        String s = text1;
        int lastIndexFound = 1;
        int counter = 0;
        for (char c : charARray) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    counter++;
                    s = s.substring(i);
                    break;
                }
            }
            lastIndexFound = counter;
        }
        return lastIndexFound;
    }

    public int longestCommon(String text1, String text2) {

        int len = 0;
        for (int i = 0; i < text2.length(); i++) {
            len = Math.max(longestCommonSubsequenceRec(text1, text2.substring(i)), len);
            System.out.println(len);
            if (len >= text2.length() / 2) {
                break;
            }
        }
        return len;

    }


    public int longestCommonSubsequenceRec(String text1, String text2) {
        char[] charARray = text2.toCharArray();
        String s = text1;
        int lastIndexFound = 1;
        int counter = 0;
        for (char c : charARray) {
            if (s.length() == 0) break;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    counter++;
                    s = s.substring(i + 1);
                    break;
                }
            }
            lastIndexFound = counter;
        }
        return lastIndexFound;
    }

    public int longestCommonSubsequence12(String text1, String text2) {

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();

        return recur(c1, c2, 0, 0);

    }

    public int recur(char[] c1, char[] c2, int i, int j) {

        if (i == c1.length || j == c2.length) return 0;

        if (c1[i] == c2[j]) {
            return 1 + recur(c1, c2, i + 1, j + 1);
        } else {
            return Math.max(recur(c1, c2, i + 1, j), recur(c1, c2, i, j + 1));
        }


    }


    public int longestCommonSubsequenceDynamicPrograming(String text1, String text2) {

        int[][] result = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.longestCommonSubsequenceDynamicPrograming("abcde", "ace"));
       // System.out.println(l.longestCommonSubsequenceDynamicPrograming("ylqpejqbalahwr", "yrkzavgdmdgtqpg"));
    /*     System.out.println(l.longestCommon("bl", "yby"));
        System.out.println(l.longestCommon("ezupkr", "ubmrapg"));
        System.out.println(l.longestCommon("oxcpqrsvwf", "shmtulqrypy"));
        System.out.println(l.longestCommon("abcba", "abcbcba"));

        System.out.println(l.longestCommon("ylqpejqbalahwr", "yrkzavgdmdgtqpg"));
        System.out.println(l.longestCommonSubsequence12("ylqpejqbalahwr", "yrkzavgdmdgtqpg"));*/

    }
}
