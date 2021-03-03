package amazon;

/*
* Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
*
* */
public class JumpGame {

    public static int getJumpCount(int[] arr) {
        int count = 0, current = 0, maxSoFar = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int num = arr[i] + i;
            maxSoFar = Math.max(maxSoFar, num);
            if (i == current) {
                current = maxSoFar;
                count++;
            }

        }
        return count;

    }

    public static int jump(int[] nums) {
        int maxSoFar = 0, res = 0, curr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i] + i);
            if (i == curr) {
                curr = maxSoFar;
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        System.out.println(getJumpCount(nums));
        //  System.out.println(jump(nums));


    }
}
