package dp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int result = 0;
        for (int j = 0; j < m; j++) {

            int length = -1;
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[j][i] == 1) {
                    break;
                } else {
                    length++;
                }
            }
            if (length + 1 == n) {
                boolean isObstacleFound = false;
                for (int k = 0; k < n; k++) {
                    if (obstacleGrid[length][k] == 1) {
                        isObstacleFound = true;
                        break;
                    }
                }
                if (!isObstacleFound) result++;
            }

        }

        return result;
    }


    public static int DPuniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = 1;


        for (int i = 1; i < columns; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int j = 1; j < rows; j++) {
            if (obstacleGrid[j][0] != 1) {
                dp[j][0] = dp[j - 1][0];
            }
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[rows - 1][columns - 1];
    }


    public static void main(String[] args) {

        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        //System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(DPuniquePathsWithObstacles(obstacleGrid));
        // LocalDate d = LocalDate.parse("1906-12-05");                   // import java.time.LocalDate;
        //LocalDate d1 = LocalDate.parse("1966-12-05");
       /* SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String inputString1 = "1927-01-30";
        String inputString2 = "2018-12-20";

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/
    }
}
