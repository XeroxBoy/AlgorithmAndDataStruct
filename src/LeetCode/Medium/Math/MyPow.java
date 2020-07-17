package LeetCode.Medium.Math;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(10, 2));
        System.out.println(new MyPow().myPow(10, -2));
        System.out.println(new MyPow().myPow_Recursion(10, 2));
        System.out.println(new MyPow().myPow_Recursion(10, -2));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public double myPow_Recursion(double x, int n) {
        // 特判，也可以认为是递归终止条件
        long N = n;
        if (N < 0) {
            return 1 / myPow(x, -N);
        }
        return myPow(x, N);
    }

    private double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (x == 1) {
            return 1;
        }

        // 根据指数是奇数还是偶数进行分类讨论
        // 使用位运算的 与 运算符代替了求余数运算

        if ((n % 2) == 0) {
            // 分治思想：分
            double square = myPow(x, n / 2);
            // 分治思想：合，下面同理
            return square * square;
        } else {
            // 是奇数的时候
            double square = myPow(x, (n - 1) / 2);
            return square * square * x;
        }
    }

}
