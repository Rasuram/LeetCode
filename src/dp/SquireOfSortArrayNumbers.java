package dp;

public class SquireOfSortArrayNumbers {


    public int[] squireArray(int[] inputarray) {
        sort(inputarray, 0, inputarray.length - 1);
        return inputarray;
    }


    private void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, right, mid);
        }
    }

    private void merge(int[] array, int left, int right, int mid) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            r[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                array[k] = l[i];
                i++;
            } else {
                array[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = l[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = r[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] in = {-9, -2, 0, 2, 3};
        SquireOfSortArrayNumbers s = new SquireOfSortArrayNumbers();
        for(int i=0;i<in.length;i++){
            in[i] = in[i] * in[i];
        }
        s.squireArray(in);
        System.out.println(in);
    }
}
