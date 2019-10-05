package LeetCode.Easy.DP;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 0) return 0;
        int smallestPrice = prices[0];
        for (int firstPrice : prices) {
            smallestPrice = Math.min(smallestPrice, firstPrice);
            maxProfit = Math.max(firstPrice - smallestPrice, maxProfit);
        }
        return maxProfit;
    }
}
