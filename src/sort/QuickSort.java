package sort;

/*
𝑛<𝑛∗𝑙𝑜𝑔(𝑛)<𝑛2
* time complexity O(NlogN) average*/

public class QuickSort {

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[((left + right) / 2)];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    public static void main(String[] args) {

        int[] ints = {7, 8, 1, 3, 5, 12};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(ints);
    }
}
