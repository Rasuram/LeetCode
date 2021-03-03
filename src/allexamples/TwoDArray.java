package allexamples;

public class TwoDArray {


    public static boolean searchMatrix(int[][] matrix, int target) {
        //int[][] arr = {{2, 3, 1}, {8, 5, 6}};
        int last = 0, first = 0;
        boolean searchFind = false;
        for (int i = 0; i < matrix.length; i++) {
            first = matrix[i][0];
            if (last != 0 && first < last) {
                return false;
            }
            for (int j = 0; j < matrix[i].length; j++) {

                last = matrix[i][j];
                if (last == target) {
                    return true;
                }
            }
        }
        return false;

    }


    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 35;
        System.out.println(searchMatrix(matrix, target));
    }
}
