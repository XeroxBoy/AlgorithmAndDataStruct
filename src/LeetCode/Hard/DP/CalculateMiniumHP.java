package LeetCode.Hard.DP;

import java.util.Arrays;

public class CalculateMiniumHP {
    public static void main(String[] args) {
        System.out.println(new CalculateMiniumHP().calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}
        ));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
