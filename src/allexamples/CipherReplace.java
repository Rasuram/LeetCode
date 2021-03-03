package allexamples;

public class CipherReplace {
    public String solution(String word, String cipher) {
        // Type your solution here
        String str = "";
        if (cipher.length() < 26) {
            return "";
        }

        for (int i = 0; i < cipher.length(); i++) {
            for (int j = i+1; j < cipher.length(); j++) {
                if (cipher.charAt(i) == cipher.charAt(j)) {
                    return "";
                }
            }
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a') {
                int pos = c - 'a';

                str += cipher.charAt(pos);
            } else {
                return "";
            }

        }
        return str;
    }

    public static void main(String[] args) {
        CipherReplace c = new CipherReplace();
        c.solution("helloworld","bjosxcqukmrhgeeynazldwfpvti");

    }
}
