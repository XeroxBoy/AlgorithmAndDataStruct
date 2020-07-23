package LeetCode.Medium.DP;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        int horizental_len = 0;
        for (int i = 0; i < dp.length; i++) {
            horizental_len += grid[i][0];
            dp[i][0] = horizental_len;
        }
        int level_len = dp[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            level_len += grid[0][i];
            dp[0][i] = level_len;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
