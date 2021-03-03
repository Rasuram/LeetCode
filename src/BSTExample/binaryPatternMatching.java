package BSTExample;

import java.util.List;

public class binaryPatternMatching {


    static int getSPatternMatchingSubString(String pattern,String input){

        char[] c = input.toCharArray();

        String str = "";
        for(int i=0;i<c.length;i++){
            if(c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u'||c[i]=='y'){
                str+="0";
            }else{
                str+="1";
            }
        }

        int M = pattern.length();
        int N = str.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++)
        {
            /* For current index i, check for
            pattern match */
            int j;
            for (j = 0; j < M; j++)
            {
                if (str.charAt(i + j) != pattern.charAt(j))
                {
                    break;
                }
            }

            // If pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M)
            {
                res++;
                j = 0;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(getSPatternMatchingSubString("10","helloworld"));
    }
}
