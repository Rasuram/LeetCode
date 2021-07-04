package allexamples;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {


    public static boolean isValid(int[][] input) {


        for (int i = 0; i < input.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            Set<Integer> box = new HashSet<>();
            System.out.print("\n");
            for (int j = 0; j < input[0].length; j++) {

                int x = (i / 3) * 3 + (j / 3);
                int y = (j / 3) * 3 + (i % 3);
                int no = input[(j / 3) * 3][y];
                System.out.print(no);

                if (!colSet.add(input[i][j])) {
                    return false;
                }

                if (!rowSet.add(input[i][j])) {
                    return false;
                }

                if (!box.add(no)) {
                    return false;
                }

            }
        }
        return true;

    }


    public static boolean isValid1(int[][] input) {

        HashSet<Integer>[] row = new HashSet[9];
        HashSet<Integer>[] col = new HashSet[9];
        HashSet<Integer>[] box = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int no = input[i][j];
                int b = (i / 3) * 3 + (j / 3);

                if (!row[i].add(no) || !col[j].add(no) || !box[b].add(no)) {
                    return false;
                }

            }
        }
        return true;
    }


    public static void main(String[] args) {

        int[][] input = {
                {2, 9, 5, 7, 4, 3, 8, 6, 1},
                {4, 3, 1, 8, 6, 5, 9, 2, 7},
                {8, 7, 6, 1, 9, 2, 5, 4, 3},
                {3, 8, 7, 4, 5, 9, 2, 1, 6},
                {6, 1, 2, 3, 8, 7, 4, 9, 5},
                {5, 4, 9, 2, 1, 6, 7, 3, 8},
                {7, 6, 3, 5, 2, 4, 1, 8, 9},
                {9, 2, 8, 6, 7, 1, 3, 5, 4},
                {1, 5, 4, 9, 3, 8, 6, 7, 2},
        };
        System.out.println(isValid1(input));

    }

}
