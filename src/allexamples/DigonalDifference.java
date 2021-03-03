package allexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DigonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int size = arr.size();
        int add1=0;
        int add2=0;
        for(int i=0 ; i < size ; i++){
            add1 = add1+  arr.get(i).get(i);
            add2 = add2+ arr.get(i).get(size -i-1);

        }

        int absoluteValue =Math.abs( add1 - add2);

        return absoluteValue;

    }

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("positive",0);
        map.put("negative",0);
        map.put("zero",0);
        Arrays.sort(new int[][]{arr}, Collections.reverseOrder());
        for(int i: arr){
            String type =  i>0?"positive":((i==0)?"zero":"negative");
            map.put(type,map.get(type)+1);
        }
        int[] arr1 =  new int[arr.length];
        int counter=0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(String.format("%.5f", (double)(entry.getValue())/6));
        }
    }


    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(11,2,4));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(10,8,-12));
        //diagonalDifference(list);
        int[] inter = new int[]{-4,3,-9,0,4,1};
        plusMinus(inter);


    }
}
