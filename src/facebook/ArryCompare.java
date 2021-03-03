package facebook;

import java.util.Arrays;

public class ArryCompare {

    static boolean elementFound(int[] arr, int a){
        boolean found = false;
        for (int value : arr) {
            if (value == a) {
                found = true;
                break;
            }

        }
        return found;
    }


    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        boolean found = false;
        for (int value : array_a) {
            if (elementFound(array_b, value)) {
                found = true;
            } else {
                found = false;
                break;
            }

        }
        return found;

    }



    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{1, 4, 3, 3};
        System.out.println(areTheyEqual(A, B));
        System.out.println(Arrays.equals(A, B));
    }
}
