package LeetCode.Top100.DP;

import java.util.ArrayList;

public class NumSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {//从f[1]开始计算
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) minVal = Math.min(minVal, f[i - j * j]);
            f[i] = minVal + 1;
        }
        return f[n];
    }
}
