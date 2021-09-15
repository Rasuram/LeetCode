package allexamples;

public class StockBuySell {

    public static int maxProfit(int[] prices) {
        int max = 0;
        int buy = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else {
                max = Math.max(max, price - buy);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] stock = {7, 1, 5, 3, 6, 4};
        int[] stock1 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(stock));
        System.out.println(maxProfit(stock1));
    }
}
