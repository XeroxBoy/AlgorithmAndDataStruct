package LeetCode.Medium.List;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal {
    public static void main(String[] args) {
        new MinimumTotal();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        int row = 1;
        int nowCol = 1;
        dp[0] = triangle.get(0).get(0);
        while (row < size) {
            dp[row] = dp[row - 1] + triangle.get(row).get(row);
            for (int i = nowCol - 1; i > 0; i--) {
                dp[i] = Math.min(dp[i], dp[i - 1]) + triangle.get(row).get(i);
            }
            dp[0] = dp[0] + triangle.get(row).get(0);
            nowCol++;
            row++;
        }
        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < nowCol; i++) {
            minResult = Math.min(minResult, dp[i]);
        }
        return minResult;
    }
}
