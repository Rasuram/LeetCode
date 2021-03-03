package leetcodeeasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThirdLargestNumber {

    public static int thirdMax(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int max = 0;
        bubbleSort(nums);

        if(nums.length<3){
            return nums[nums.length-1];
        }
        return nums[nums.length-3];
    }

    private static int[] bubbleSort(int[] arr){
        boolean flag=false;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                flag=true;
            }
        }
        return flag?bubbleSort(arr):arr;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 1};
      //  System.out.println(thirdMax(a));


        System.out.println((char)65+28);
        System.out.println(1+'A');
    }
}
