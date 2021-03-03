package slack;

/*
* Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
* Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.
* */
public class KPlaceAway {


    public static boolean isKPlacesAway(int[] input, int k) {
        int foundIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (foundIndex == 0 && input[i] == 1 || (input[i] == 1 && foundIndex + i == k)) {
                foundIndex = i;
            } else {
                if (foundIndex + i == k && input[i] != 1) {
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;
        System.out.println(isKPlacesAway(nums, k));
    }
}
