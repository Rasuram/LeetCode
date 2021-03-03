package allexamples;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {


    private static int fib(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(solution(7));
    }

    private static long fib(int n,long[] arr){

        if(n==0 || n==1){
            return 1;
        }
        return fib(n-1,arr)+fib(n-2,arr);
    }




    public static long[] solution(long n) {
        // Type your solution here
       long[] l2 = new long[(int) n];
        int counter=0;
        for(int i=0;i<n;i++){
            long s = fib(i);
            if(s%2==1 && s>1 && s%i!=0 || s==2){
                l2[counter] = s;
                counter++;
            }

        }
        long[] newArray = new long[counter];
        System.arraycopy( l2, 0, newArray, 0, counter );


        return newArray;
    }
}
