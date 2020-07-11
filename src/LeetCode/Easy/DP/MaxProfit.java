package LeetCode.Easy.DP;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println(new MaxProfit().maxProfit(prices));
        System.out.println(new MaxProfit().maxProfit(prices1));
        System.out.println(new MaxProfit().other_maxProfit(prices));
        System.out.println(new MaxProfit().other_maxProfit(prices1));
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

    //假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1]
    // 之间选最低点买入；所以遍历数组，依次求每个卖出时机的的最大差值，再从中取最大值。
    public int other_maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int first_price = prices[0];
        for (int temp_price : prices) {
            first_price = Math.min(temp_price, first_price);
            maxProfit = Math.max(maxProfit, temp_price - first_price);
        }
        return maxProfit;
    }
//    public max_profit(int[] prices){
//        int n = prices.size();
//        if(n <= 1)
//            return 0;
//        // 第一维n个状态：n天，第二维2个状态：0（不持有股票）、1（持有股票）
//        // 第三维3个状态：0、1、2分别表示完成的交易次数
//        int dp[n][2][3];
//
//        // 初始化
//        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = 0;
//        dp[0][1][0] = dp[0][1][1] = dp[0][1][2] = -prices[0];
//        for(int i = 1; i < n; i++)
//        {
//            dp[i][0][0] = 0;
//            dp[i][0][1] = max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
//            dp[i][0][2] = max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
//            dp[i][1][0] = max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
//            dp[i][1][1] = max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
//            dp[i][1][2] = 0;
//        }
//        return max(dp[n - 1][0][2], dp[n - 1][0][1]);
//    }

}
