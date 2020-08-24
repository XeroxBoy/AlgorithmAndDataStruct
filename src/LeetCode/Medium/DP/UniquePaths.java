package LeetCode.Medium.DP;

public class UniquePaths {
    private int finishPath = 0;
    private int rowLimit, colLimit;

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
//        rowLimit = m;
//        colLimit = n;
//        finishPath = 0;
//        dfs(0, 0);
//        return finishPath;
    }

    private void dfs(int row, int col) {
        if (row >= rowLimit || col >= colLimit) return;
        if (row == rowLimit - 1 && col == colLimit - 1) {
            finishPath += 1;
            return;
        }
        dfs(row + 1, col);
        dfs(row, col + 1);
    }
}
