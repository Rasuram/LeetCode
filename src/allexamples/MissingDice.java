package allexamples;

import java.util.Arrays;

public class MissingDice {

    public static int[] solution(int[] A, int F, int M) {
        if (F < 0 || M < 1 || M > 6) return new int[]{0};
        int[] res = new int[F];
        int totalRolls = A.length + F;
        int sum = 0;

        for (int el : A) sum += el;

        //sum  = M*totalrolls-sum
        int numForF = (M * totalRolls) - sum;

        if (F > numForF || numForF / F > 6) return new int[]{0};

        for (int i = 0; i < res.length; i++) {
            res[i] = numForF / F--;
            numForF -= res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 4, 3};
        int F = 2;
        int M = 4;
        System.out.println(Arrays.toString(solution(A, F, M)));
    }
}
