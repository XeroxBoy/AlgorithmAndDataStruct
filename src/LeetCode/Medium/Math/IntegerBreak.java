package LeetCode.Medium.Math;


public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
        System.out.println(new IntegerBreak().integerBreak(3));
        System.out.println(new IntegerBreak().integerBreak(4));
        System.out.println(new IntegerBreak().integerBreak(6));
        System.out.println(new IntegerBreak().integerBreak(10));
        System.out.println(new IntegerBreak().integerBreak(11));

    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int now_Max = 0;
            for (int j = 1; j < i; j++) {
                now_Max = Math.max(now_Max, Math.max((i - j) * j, (i - j) * dp[j]));
            }
            dp[i] = now_Max;
        }
        return dp[n];
    }

    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) return n - 1;
            int a = n / 3, b = n % 3;
            if (b == 0) return (int) Math.pow(3, a);
            if (b == 1) return (int) Math.pow(3, a - 1) * 4;
            return (int) Math.pow(3, a) * 2;
        }
    }
}
