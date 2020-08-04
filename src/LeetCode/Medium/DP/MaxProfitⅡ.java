package LeetCode.Medium.DP;

public class MaxProfitⅡ {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0];
        int MaxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            MaxProfit = Math.max(prices[i] - minPrice, MaxProfit);
        }
        return MaxProfit;
    }
}
