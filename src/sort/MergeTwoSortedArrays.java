package sort;

public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Concatenate two arrays
        int i = 0, j = 0, k = 0;
        int[] temp = new int[m+n];
        while (i <= m && j <= n) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i++];
            } else {
                temp[k] = nums2[j++];
            }
            k++;
        }

        System.arraycopy(nums1, i, temp, k, m - i+1);
        System.arraycopy(nums2, j, temp, k+m-i, n - j);
        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};


        int n = 3;
        mergeTwoSortedArrays.merge(nums1, m, nums2, n);
    }
}
