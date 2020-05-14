package LeetCode.Medium.Math;

public class pow {
    public static void main(String[] args) {
        System.out.println(new pow().myPow(2, -2));
    }

    public double myPow(double x, int n) {
        double result = 1.0;
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }
        result = quickMi(x, n);
        if (isNegative) result = 1.0 / result;
        return result;
    }

    private double quickMi(double x, int N) {
        if (N == 0) return 1.0;
        double y = quickMi(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;

    }

    class Solution {
        double quickMul(double x, long N) {
            double ans = 1.0;
            // 贡献的初始值为 x
            double x_contribute = x;
            // 在对 N 进行二进制拆分的同时计算答案
            while (N > 0) {
                if (N % 2 == 1) {
                    // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                    ans *= x_contribute;
                }
                // 将贡献不断地平方
                x_contribute *= x_contribute;
                // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
                N /= 2;
            }
            return ans;
        }

        public double myPow(double x, int n) {
            long N = n;
            return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }
    }
}
