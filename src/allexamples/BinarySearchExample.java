package allexamples;

public class BinarySearchExample {


    static void binarySearch(int arr[], int first, int last, int k) {
        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] < k) {
                first = mid + 1;
            } else if (arr[mid] == k) {
                System.out.println("Element found at: " + mid);
                break;
            } else {
                last = mid - 1;
            }
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }
    }

    static void search(int arr[], int first, int last, int k) {

        if (arr.length == 0) {
            System.out.println("no element found to search");
        }

        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] < k) {
                first = mid + 1;
            } else if (arr[mid] == k) {
                System.out.println("element found at :" + mid);
                break;
            } else {
                last = mid - 1;
            }
        }
        if (first > last) {
            System.out.println("Element is not found!");
        }

    }


    public static int findMin(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        //int arr[] = {10, 20, 30, 40, 50};
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        int key = 50;
        int last = arr.length - 1;
        search(arr, 0, last, key);
        System.out.println(findMin(arr));
    }


}
