package allexamples;

import java.util.*;

/*
*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
* Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
* */
public class TrippleSum {

    public static List<Set<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        //set.add(new ArrayList<>());
      //  permuteHelper(set, new HashSet<>(), nums);
        //getTripples(set, new HashSet<>(), nums);
        ThreePointer(set,nums);
        return null;
    }

    public static void getTripples(List<Set<Integer>> result, Set<Integer> triple, int[] nums) {
        if (triple.size() == 3) {
            result.add(triple);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (result.contains(nums[i])) {
                    continue;
                }
                triple.add(nums[i]);
                getTripples(result, triple, nums);
            }
        }

    }

    public static List<List<Integer>> ThreePointer(Set<List<Integer>> result, int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p = i + 1;
            int q = nums.length - 1;
            int x = nums[i];
            while (p < q) {
                if (x + nums[p] + nums[q] == 0) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(x);
                    triple.add(nums[p]);
                    triple.add(nums[q]);
                    result.add(triple);
                    p++;
                    q--;
                } else if (x + nums[p] + nums[q] < 0) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void Two(List<Set<Integer>> result, int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int p = i + 1;
            int q = nums.length - 1;
            int x = nums[i];
            while (p < q) {
                if (x + nums[p] + nums[q] == 0) {
                    Set<Integer> triple = new HashSet<>();
                    triple.add(x);
                    triple.add(nums[p]);
                    triple.add(nums[q]);
                    result.add(triple);
                } else if (x + nums[p] + nums[q] < 0) {
                    p++;
                } else {
                    q--;
                }
            }
        }
    }


    private static void permuteHelper(List<Set<Integer>> list, Set<Integer> resultList, int[] arr) {

        // Base case
        if (resultList.size() == 3) {
            list.add(new HashSet<>(resultList));
        } else {
            for (int j : arr) {

                if (resultList.contains(j)) {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(j);
                // Explore
                permuteHelper(list, resultList, arr);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

}
