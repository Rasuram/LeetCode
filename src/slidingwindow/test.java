package slidingwindow;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    private static int ON = 1;
    private static int OFF = 0;

    public static int[][] to2dArrayFromList(ArrayList<ArrayList<Integer>> result) {
        int[][] resArray = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> row = result.get(i);
            resArray[i] = new int[]{row.get(0),row.get(1)};
        }
        return resArray;
    }

    // 0         5   7                                             30 31          36
    // + + + + + + - - + + + + + + + + + + + + + + + + + + + + + + +  - + + + + + +
    // input: [[5, ON], [7, OFF], [30, ON], [31, OFF], [36, ON]]
    // output: [[5,7], [30,31]]
    public static int[][] offlineIntervals(int[][] statuses) {
        // START CODING HERE

        if(statuses.length==0){
            return statuses;
        }

        //Arrays.sort((statuses,Comparator.comapringInt()))
        int n = statuses.length-1;

        int i=0,j=1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(i<n){
            int[] a = statuses[i];
            int[] b = statuses[j];

            ArrayList<Integer> intervals = new ArrayList<>();
            if(a[1]==ON && b[1]==OFF){

                intervals.add(a[0]);
                intervals.add(b[0]);
                result.add(intervals);
            }

            i++;
            j++;
        }
        return to2dArrayFromList(result);
    }

    public static String twoDimArrayToString(int[][] arr) {
        String[] innerStr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            innerStr[i] = Arrays.toString(arr[i]);
        }
        return Arrays.toString(innerStr);
    }

    public static void main(String[] args) {
        int[][] statuses = new int[][] {{5, ON}, {7, OFF}, {30, ON}, {31, OFF}, {36, ON}};
        System.out.println(twoDimArrayToString(offlineIntervals(statuses)));
    }
}

