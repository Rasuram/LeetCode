package Karat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramInt {

    static long digitAnagrams(int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        long counter = 0;
        for (int i = 0; i < a.length - 1; i++) {
            int n = a[i];
            int reverse = 0;
            while (n >= 0) {
                reverse = reverse * 10 + n % 10;
                n = n / 10;
            }

            if (list.contains(reverse)) {
                System.out.println(reverse);
                counter++;
            }
        }
        return counter;

    }

    public static void main(String[] args) {
        int[] a = {936442860, 509389019, 482540391, 623484864, 451717531, 442362118, 351571714};
        digitAnagrams(a);
    }

}
