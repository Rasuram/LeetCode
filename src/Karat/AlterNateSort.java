package Karat;

public class AlterNateSort {

    static boolean alternatingSort(int[] a) {

        int j = a.length - 1;
        int i = 0;
        int[] result = new int[j + 1];
        int counter = 0;
        while (i <= j) {
            if (a[i] < a[j]) {
                result[counter++] = a[i];
                result[counter++] = a[j];
                i++;
                j--;
            }
            return false;

        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {-92, -23, 0, 45, 89, 96, 99, 95, 89, 41, -17, -48};
        //-92,-48,-23,-17,0,41,45,89,89,89,96,95
        System.out.println(alternatingSort(a));
    }

}
