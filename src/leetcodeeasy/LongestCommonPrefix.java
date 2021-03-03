package leetcodeeasy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length > 0) {
            char[] ch = strs[0].toCharArray();
            String prefix = "";
            for (int i = 0; i < ch.length; i++) {
                // String[] strs = {"flower", "flow", "flight"};
                char c = ch[i];
                boolean found = false;
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].indexOf(c, i) == i && strs[j].contains(prefix + c)) {
                        found = true;
                    } else {
                        found = false;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
                prefix += c;
            }
            result = prefix.isEmpty() && strs.length == 1 ? strs[0] : prefix;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] str1 = {"flower", "flow", "flight"};
        String[] str2 = {"dog", "racecar", "car"};
        String[] str3 = {"aa", "aa"};
        String[] str4 = {"aca","cba"};
        String[] str5 = {"flower", "flower", "flower", "flower"};


        System.out.println(l.longestCommonPrefix(str1));
        System.out.println(l.longestCommonPrefix(str4));
        System.out.println(l.longestCommonPrefix(str5));
        System.out.println(l.longestCommonPrefix(str3));
    }
}
