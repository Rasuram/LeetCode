package leetcodeeasy;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3) {
            return false;
        }
        return ismOuntainArray(arr, 0, arr.length);

    }

    public boolean ismOuntainArray(int[] arr, int left, int right) {

        boolean peakFound = false;
        boolean increasing = false;
        for (int i = 1; i < arr.length; i++) {
            if (peakFound && arr[i - 1] == arr[i]) {
                return false;
            }
            if (peakFound && arr[i - 1] < arr[i]) {
                return false;
            } else {
                if (arr[i - 1] > arr[i] && i - 1 == 0) {
                    return false;
                } else if (!peakFound && increasing && arr[i - 1] > arr[i]) {
                    peakFound = true;

                } else {
                    if (!peakFound && i + 1<arr.length-1 && arr[i] < arr[i + 1])
                        increasing = true;
                }
            }

        }
        return peakFound;
    }

    public static void main(String[] args) {
        ValidMountainArray v = new ValidMountainArray();
        int[] aa = {0,3,2,1};
        System.out.println(v.validMountainArray(aa));
        System.out.println(Math.abs(Math.sqrt(8)));
    }
}
