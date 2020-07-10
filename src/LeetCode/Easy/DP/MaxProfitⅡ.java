package LeetCode.Easy.DP;

public class MaxProfitⅡ {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfitⅡ().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length < 2) {
            return result;
        }

        // 只要后项大于前项，则累加到结果中。
        // 想象连续两次涨，就累加了两次的差值，其实就等于 第三次卖 - 第一次买的差值
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += (prices[i] - prices[i - 1]);
            }
        }
        return result;
    }

    class Solution {
        public int maxProfit(int[] prices) {
            int result = 0;
            if (prices.length < 2) {
                return result;
            }

            // 只要后项大于前项，则累加到结果中。
            // 想象连续两次涨，就累加了两次的差值，其实就等于 第三次卖 - 第一次买的差值
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += (prices[i] - prices[i - 1]);
                }
            }
            return result;
        }
    }

}
