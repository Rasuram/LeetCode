package sort;

public class BubbleSort {


    private static int[] bubbleSort(int[] arr){
        boolean flag=false;
        for(int i=1;i<arr.length;i++){
         if(arr[i]<arr[i-1]){
             int temp = arr[i];
             arr[i] = arr[i-1];
             arr[i-1] = temp;
             flag=true;
         }
        }
        return flag?bubbleSort(arr):arr;
    }


    static void staircase(int n) {
        for(int i=0;i<=n;i++){
           int k = n-i;
            for(int j=0;j<=n-i;j++){
                System.out.print(" ");
            }

            for(int j=0;j<n-k;j++){
                System.out.print("#");
            }
            System.out.println(" ");


        }
    }



    public static void main(String[] args) {
        int[] i = new int[]{2,7,4,1,5,3};
        i = bubbleSort(i);
        System.out.println();
        staircase(6);

    }
}
