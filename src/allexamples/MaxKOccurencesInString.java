package allexamples;

public class MaxKOccurencesInString {

    static int[] occurences(String sequence, String[] words) {
        int[] in = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String st = words[i];
            int count = 0;
            int index = 0;
            while (true) {
                int found = sequence.indexOf(st, index);
                if ((count == 0 && found >= 0)) {
                    count++;
                    index += found + st.length();
                } else if (found >= 0 && count > 0 && found == index) {
                    count++;
                    index += st.length();
                } else {
                    break;
                }
            }
            in[i] = count;
        }
        return in;
    }
    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        String tmp = word;

        while(sequence.contains(tmp)) {
            count++;
            tmp += word;
        }

        return count;
    }
    static private  int[] maxKoccurences(String sequence, String[] words) {

        int n= words.length;
        int[] result = new int[n];

        if (n==0 || sequence.length() == 0)
            return result;

        for (int i=0;i< n;i++) {
            String word = words[i];

            int count = 0;
            String tmp = word;
            while (true) {
                int index = sequence.indexOf(tmp);
                if (index == -1)
                    break;
                else {
                    count++;
                    tmp += word;
                }
            }

            result[i] = count;
        }

        return result;
    }


    public static void main(String[] args) {
        String[] words = {"ab", "babc", "bca"};
       // System.out.println(maxKoccurences("ababcbabc", words));
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));

    }
}




