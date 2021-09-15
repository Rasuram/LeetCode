package adobe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class inverseEqual {


    // Function to check if the inverse
// permutation of the given array is
// same as the original array
    static void inverseEqual(int arr[], int n) {

        // Stores the inverse
        // permutation
        int[] brr = new int[n];

        // Generate the inverse permutation
        for (int i = 0; i < n; i++) {
            int present_index = arr[i] - 1;
            brr[present_index] = i + 1;
        }

        // Check if the inverse permutation
        // is same as the given array
        for (int i = 0; i < n; i++) {
            if (arr[i] != brr[i]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private static void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            swap(nums, i, start);
            helper(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /*
    *
    *
    *
    * /**
    Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    var permute = function(nums,set=[],ans=[]) {


        if(!nums.length)ans.push([...set]);

        for(let i=0;i<nums.length;i++){
            var subset = nums.filter((num,index)=>index!==i);
            set.push(nums[i]);
            permute(subset,set,ans);
            set.pop();

        }
        return ans;

    }
    */

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }
        return A;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 4, 3, 2};

        int[] arr1 = new int[4];
        for (int i = 0; i <4; i++) {
            arr1[i] = i+1;
        }
        System.out.println(permuteUnique(arr1));
    }
}

