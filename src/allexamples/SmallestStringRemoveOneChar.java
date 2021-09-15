package allexamples;

import java.util.Arrays;

public class SmallestStringRemoveOneChar {

    // Function to return the smallest String
    static String smallest(String s) {
        int l = s.length();
        String ans = "";

        // iterate the String
        for (int i = 0; i < l - 1; i++) {

            // first point where s[i]>s[i+1]
            if (s.charAt(i) > s.charAt(i + 1)) {

                // append the String without
                // i-th character in it
                for (int j = 0; j < l; j++) {
                    if (i != j) {
                        ans += s.charAt(j);
                    }
                }
                return ans;
            }
        }

        // leave the last character
        ans = s.substring(0, l - 1);
        return ans;
    }


    static String smallest1(String s) {
        int l = s.length();
        char arr[]=s.toCharArray();
       Arrays.sort(arr);

       String temp=new String(arr);
      char c= temp.charAt(temp.length()-1);

      StringBuffer sb= new StringBuffer(s);
     sb.deleteCharAt( sb.indexOf(c+""));

     return sb.toString();

    }

    // Driver Code
    public static void main(String[] args) {

        String s = "abcda";
        String s1 = "abc";
        System.out.println(smallest1(s));
        System.out.println(smallest1(s1));
    }
}
