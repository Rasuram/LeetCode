package leetcodeeasy;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {


        return plant(flowerbed, n);
    }


    boolean plant(int[] bed, int n) {

        if (n <= 0) {
            return true;
        }
        for (int i = 0; i < bed.length; i++) {
            if (n!=0 && ((bed[i] == 0 && i + 1 < bed.length - 1) &&
                    (bed[i + 1] != 1 && (i == 0 || (bed[i - 1] != 1))) || (bed[i] == 0 && i == bed.length - 1 && (bed[i - 1] != 1)))) {
                bed[i]=1;
                n--;
            }

        }
        return n==0;

    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] bed = {0, 1, 0};
        int[] bed1 = {1, 0, 0, 0, 1};
        int[] bed2 = {0, 0, 1, 0, 1};
        int[] bed3 = {1, 0, 0, 0, 1, 0, 0};
        int[] bed4 = {0,0,1,0,0};
        //  System.out.println(canPlaceFlowers.canPlaceFlowers(bed, 2));
        System.out.println(canPlaceFlowers.canPlaceFlowers(bed4, 1));
    }
}
