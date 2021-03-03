package decimal;

import java.util.Arrays;

public class DecimalBinaryStack {


    public static void main(String[] args) {
        int n = 10;
        int[] arr = {5, 6, 7, 8, 9};
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
        System.out.println(Arrays.toString(arr));
        //System.out.println(Integer.toBinaryString(n));
    }
}
