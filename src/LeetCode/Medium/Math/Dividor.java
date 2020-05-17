package LeetCode.Medium.Math;

public class Dividor {

    public static void main(String[] args) {
        System.out.println(new Dividor().divide(-2147483648, -1));
        System.out.println(new Dividor().divide(-2147483648, 1));
        System.out.println(new Dividor().divide(10, 3));
        System.out.println(new Dividor().divide(-15, 4));
        System.out.println(new Dividor().divide(-2147483648,
                2));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
        }
        boolean notSameFlag = true;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) notSameFlag = false;
        long dividend_long = dividend;
        long divisor_long = divisor;
        dividend_long = dividend_long > 0 ? dividend_long : -dividend_long;
        divisor_long = divisor_long > 0 ? divisor_long : -divisor_long;
        long counter = div(dividend_long, divisor_long);
        if (notSameFlag) counter = -counter;
        return (int) counter;
    }

    public long div(long a, long b) {  // 似乎精髓和难点就在于下面这几句
        if (a < b) return 0;
        int count = 1;
        long tb = b; // 在后面的代码中不更新b
        while ((tb + tb) <= a) {
            count = count + count; // 最小解翻倍
            tb = tb + tb; // 当前测试的值也翻倍
        }
        return count + div(a - tb, b);
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            boolean negative;
            negative = (dividend ^ divisor) < 0;//用异或来计算是否符号相异
            long t = Math.abs((long) dividend);
            long d = Math.abs((long) divisor);
            int result = 0;
            for (int i = 31; i >= 0; i--) {
                if ((t >> i) >= d) {//找出足够大的数2^n*divisor
                    result += 1 << i;//将结果加上2^n
                    t -= d << i;//将被除数减去2^n*divisor
                }
            }
            return negative ? -result : result;//符号相异取反
        }
    }
}
