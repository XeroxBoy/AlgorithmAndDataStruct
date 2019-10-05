package LeetCode.Easy.DP;

public class MaxProfitⅡ {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfitⅡ().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int firstNum = prices[i];
            int j = i + 1;
            boolean flag = false;
            while (j < prices.length && prices[j] > prices[i]) {
                j++;
                i++;
                flag = true;
            }
            if (flag) {
                maxProfit += prices[i] - firstNum;
            }
        }
        return maxProfit;
    }
}
