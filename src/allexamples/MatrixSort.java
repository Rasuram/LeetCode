package allexamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.addAll;

public class MatrixSort {


    private static void sortMatrix(Integer[][] pArr) {
        List<Integer> tmpList = new ArrayList<>();

        for (Integer[] lArr : pArr)
            addAll(tmpList, lArr);

        Collections.sort(tmpList);

        for (int i = 0; i < pArr.length; i++)
            for (int j = 0; j < pArr.length; j++)
                pArr[i][j] = tmpList.remove(0);


        System.out.println(pArr);
    }

    public static int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 0;
        int profit = 0;

        for(int i =1; i<prices.length; i++) {

            if(prices[i] > prices[i-1]) {
                sell++;
            }

            else {
                profit += prices[sell] - prices[buy];
                buy = sell = i;
            }
        }

        profit += prices[sell] - prices[buy];

        return profit;
    }

    public static void main(String[] args) {


        Integer[][] matrix = {{9, 7, -4, 5}, {1, 6, 2, -6}, {12, 20, 2, 0}};
        sortMatrix(matrix);
        int[] prices = {1,2,100};
        System.out.println(maxProfit(prices));

    }
}
