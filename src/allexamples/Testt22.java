package allexamples; /**
 * Returns true if the provided String is a number, or false if it is not
 **/
// "+3.14   " -> true;
// "what" -> false
// "+3.14+"sfs" -> false;
// "3+"234" -> false;
// "3+234"
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Testt22 {

    static boolean isNumber(String input) {

        if(input==null || input.length()==0){
            return false;
        }

        char[] arr = input.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='a' && arr[i]<='z'){
                return false;
            }
        }
        return true;
    }



    static boolean isNumber1(String input) {

        if(input==null || input.length()==0){
            return false;
        }

        char[] arr = input.toCharArray();
        boolean isNumber=false;
        boolean isDecimal = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>='a' && arr[i]<='z'){
                return false;
            }
            if(arr[i]=='.'){
                if(isDecimal){
                    return false;
                }
                isDecimal = true;
            }
            if(arr[i]>='0' && arr[i]<='9'){
                isNumber=true;
            } else if((input.charAt(0)!='+' && input.charAt(0)!='-') && (arr[i]=='-' || arr[i]=='+')){
                return false;
            }
        }
        return isNumber;
    }


    public static void main(String[] args) {
        System.out.println(isNumber1("+3.14"));
        System.out.println(isNumber1("what"));
        System.out.println(isNumber1("3.14+sfs"));
        System.out.println(isNumber1("-3.14"));
    }
}
