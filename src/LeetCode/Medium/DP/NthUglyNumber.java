package LeetCode.Medium.DP;

public class NthUglyNumber {
    public static void main(String[] args) {
        for (int i = 1; i < 1690; i++) {
            long startTime = System.currentTimeMillis();
            System.out.println("第" + i + "个质因数:" + " " + new NthUglyNumber().nthUglyNumber(i));
            System.out.println("计算时间:" + (System.currentTimeMillis() - startTime) / 1000 + 's');
        }

    }

    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
