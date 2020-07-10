package LeetCode.Medium.DP;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];//持有
        dp[0][1] = 0;//没有，冷冻
        dp[0][2] = 0;//没有，不冷冻
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            int f0 = -prices[0];
            int f1 = 0;
            int f2 = 0;
            for (int i = 1; i < n; ++i) {
                int newf0 = Math.max(f0, f2 - prices[i]);
                int newf1 = f0 + prices[i];
                int newf2 = Math.max(f1, f2);
                f0 = newf0;
                f1 = newf1;
                f2 = newf2;
            }

            return Math.max(f1, f2);
        }
    }
}
