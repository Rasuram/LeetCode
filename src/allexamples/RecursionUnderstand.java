package allexamples;

public class RecursionUnderstand {

    static int count = 0;

    public static int sumHead(int n) {

        if (n >= 1) {
            n = sumHead(n - 1) + n;
            //System.out.println(n);
        }
        return n;
    }

    public static int tailSum(int currentSum, int n) {
        if (n <= 1) {
            return currentSum + n;
        }
        return tailSum(currentSum + n, n - 1);
    }


    public static int powerOf10(int n) {
        if (n == 0) {
            return 1;
        }
        return powerOf10(n - 1) * 10;
    }

    public static int recur(int[] arr, int low, int max) {
        if (low > max) {
            return 5;
        }
        int mid = (low + max) / 2;
        count += arr[mid];
        int n = recur(arr, low, mid - 1);
        System.out.println("$$$$" + n);
        int m = recur(arr, mid + 1, max);
         System.out.println("%%%%" + m);
        return count;
    }


    public static void main(String[] args) {
        //System.out.println(tailSum(0,10));
        System.out.println(sumHead(10));
        // System.out.println(powerOf10(2));

        int[] arr = {2, 5, 6, 10, 20, 30, 40};
        System.out.println(recur(arr, 0, arr.length - 1));

    }
}
