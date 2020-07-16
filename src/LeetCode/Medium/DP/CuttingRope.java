package LeetCode.Medium.DP;

import java.util.Arrays;

public class CuttingRope {
    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(2));
        System.out.println(new CuttingRope().cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n < 3) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = i;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= 4; j++)    // j表示左侧绳子长度
            {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
