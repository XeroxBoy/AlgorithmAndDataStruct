package LeetCode.Medium.Math;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    private static List<List<String>> reasonableResults;

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        reasonableResults = new NQueen().solveNQueens(50);
//        reasonableResults = new NQueen().new Solution().solveNQueens(4);
        for (int i = 0; i < reasonableResults.size(); i++) {
            List<String> result = reasonableResults.get(i);
            for (int j = 0; j < result.size(); j++) {
                System.out.println(result.get(j));
            }
            System.out.println();
        }
        System.out.println(reasonableResults.size());
        System.out.println(System.currentTimeMillis());
    }

    public List<List<String>> solveNQueens(int n) {
        reasonableResults = new ArrayList<>();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                findNextStatus(dp, n, i);
                dp[i][j] = 0;
            }
        }
        return reasonableResults;
    }

    private void findNextStatus(int[][] dp, int length, int startRow) {
        if (startRow == length - 1) {
            buildString(dp);
        }
        for (int i = startRow + 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = 1;
                if (isValidMatrix(dp, length, startRow)) {
                    findNextStatus(dp, length, i);
                }
                dp[i][j] = 0;
            }
        }
    }

    private void buildString(int[][] dp) {
        List<String> oneResult = new ArrayList<>();
        int length = dp.length;
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            boolean hasQ = false;
            for (int j = 0; j < length; j++) {
                if (dp[i][j] == 0) sb.append(".");
                else {
                    sb.append("Q");
                    hasQ = true;
                }
            }
            if (!hasQ) return;
            oneResult.add(sb.toString());
        }
        reasonableResults.add(oneResult);
    }

    private boolean isValidMatrix(int[][] dp, int length, int startRow) {
        for (int i = startRow; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (dp[i][j] == 1) {
                    for (int k = 0; k < i; k++) {
                        if (dp[k][j] == 1) return false;
                    }
                    for (int k = 0; k < length; k++) {
                        if (k == j) continue;
                        if (dp[i][k] == 1) return false;
                    }
                    for (int k = i - 1, m = j + 1; k < length && m < length; k--, m++) {
                        if (k < 0 || m < 0) break;
                        if (dp[k][m] == 1) return false;
                    }
                    for (int k = i - 1, m = j - 1; k < length && m < length; k--, m--) {
                        if (k < 0 || m < 0) break;
                        if (dp[k][m] == 1) return false;
                    }
                }
            }
        }
        return true;
    }

    class Solution {
        // 用于标记是否被列方向的皇后被攻击
        int[] rows;
        // 用于标记是否被主对角线方向的皇后攻击
        int[] mains;
        // 用于标记是否被次对角线方向的皇后攻击
        int[] secondary;
        // 用于存储皇后放置的位置
        int[] queens;
        int n;
        private List<List<String>> output = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 初始化
            rows = new int[n];
            mains = new int[2 * n - 1];
            secondary = new int[2 * n - 1];
            queens = new int[n];
            this.n = n;

            // 从第一行开始回溯求解 N 皇后
            backtrack(0);

            return output;
        }

        // 在一行中放置一个皇后
        private void backtrack(int row) {
            if (row >= n) return;
            // 分别尝试在 row 行中的每一列中放置皇后
            for (int col = 0; col < n; col++) {
                // 判断当前放置的皇后不被其他皇后的攻击
                if (isNotUnderAttack(row, col)) {
                    // 选择，在当前的位置上放置皇后
                    placeQueen(row, col);
                    // 当当前行是最后一行，则找到了一个解决方案
                    if (row == n - 1) addSolution();
                    // 在下一行中放置皇后
                    backtrack(row + 1);
                    // 撤销，回溯，即将当前位置的皇后去掉
                    removeQueen(row, col);
                }
            }
        }

        // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
        private boolean isNotUnderAttack(int row, int col) {
            // 判断的逻辑是：
            //      1. 当前位置的这一列方向没有皇后攻击
            //      2. 当前位置的主对角线方向没有皇后攻击
            //      3. 当前位置的次对角线方向没有皇后攻击
            int res = rows[col] + mains[row - col + n - 1] + secondary[row + col];
            // 如果三个方向都没有攻击的话，则 res = 0，即当前位置不被任何的皇后攻击
            return res == 0;
        }

        // 在指定的位置上放置皇后
        private void placeQueen(int row, int col) {
            // 在 row 行，col 列 放置皇后
            queens[row] = col;
            // 当前位置的列方向已经有皇后了
            rows[col] = 1;
            // 当前位置的主对角线方向已经有皇后了
            mains[row - col + n - 1] = 1;
            // 当前位置的次对角线方向已经有皇后了
            secondary[row + col] = 1;
        }

        // 移除指定位置上的皇后
        private void removeQueen(int row, int col) {
            // 移除 row 行上的皇后
            queens[row] = 0;
            // 当前位置的列方向没有皇后了
            rows[col] = 0;
            // 当前位置的主对角线方向没有皇后了
            mains[row - col + n - 1] = 0;
            // 当前位置的次对角线方向没有皇后了
            secondary[row + col] = 0;
        }

        /**
         * 将满足条件的皇后位置放入output中
         */
        public void addSolution() {
            List<String> solution = new ArrayList<String>();
            for (int i = 0; i < n; ++i) {
                int col = queens[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < col; ++j) sb.append(".");
                sb.append("Q");
                for (int j = 0; j < n - col - 1; ++j) sb.append(".");
                solution.add(sb.toString());
            }
            output.add(solution);
        }
    }


}
