package sort;

import java.util.Arrays;

/*
n<O(nlogn)<n2
* As mentioned above, Merge Sort is an "out-of-place" sorting algorithm.
* What this means is that Merge Sort does not sort and store the elements in the memory addresses of the collection given to it,
* but instead it creates and returns a completely new collection that is the sorted version of the one provided to it.

This is an important distinction because of memory usage.
* For very large arrays this would be a disadvantage because the data will be duplicated, which can memory problems on some systems.
*
*/
public class MergeSort {


    void mergeSort(int[] arr, int low, int high) {

        if (high <= low) {
            return;
        }
        int mid = ((low + high) / 2);
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        // Creating temporary subarrays
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] array = new int[]{5, 6, 7, 2, 4, 1, 7};
        m.mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
