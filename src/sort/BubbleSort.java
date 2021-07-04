package sort;

public class BubbleSort {


    private static int[] bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                flag = true;
            }
        }
        return flag ? bubbleSort(arr) : arr;
    }


    static void staircase(int n) {
        for (int i = 0; i <= n; i++) {
            int k = n - i;
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - k; j++) {
                System.out.print("#");
            }
            System.out.println(" ");


        }
    }

    static int staircaseDp(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2]
                    + res[i - 3];

        return res[n];
    }

    public static int findStep(int n) {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        else
            return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
    }



    public static void main(String[] args) {
        int[] i = new int[]{2, 7, 4, 1, 5, 3};
        i = bubbleSort(i);
        System.out.println();
        System.out.println(staircaseDp(6));
        System.out.println(findStep(6));

    }
}
