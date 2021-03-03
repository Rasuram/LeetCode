package sort;

/*
 * n < O(nlogn) < n2
 *
 *
 * mergesort time complexity O(nlogn)
 *
 * */
public class MergeSortApproach2 {

    private void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd) {
            return;
        }
        int mid = (leftStart + rightEnd) / 2;
        mergeSort(arr, temp, leftStart, mid);
        mergeSort(arr, temp, mid + 1, rightEnd);
        mergeValues(arr, temp, leftStart, rightEnd);
    }


    private void mergeValues(int[] arr, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

    }


    public static void main(String[] args) {
        MergeSortApproach2 m = new MergeSortApproach2();
        int[] array = {5, 6, 7, 2, 4, 1, 7};
        m.mergeSort(array, new int[array.length], 0, array.length - 1);
        System.out.println(array);
    }
}
