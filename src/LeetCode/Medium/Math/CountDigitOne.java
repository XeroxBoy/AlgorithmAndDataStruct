package LeetCode.Medium.Math;

public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println(new CountDigitOne().countDigitOne(12));
        System.out.println(new CountDigitOne().countDigitOne(13));
        System.out.println(new CountDigitOne().countDigitOne(824883294));

    }

    public int countDigitOne(int n) {
        int next = 0;
        int now = 0;
        for (int i = 1; i <= n; i++) {
            int count = num_one_count(i);
            next = now + count;
            now = next;
        }
        return next;
    }

    /*
    * while high != 0 or cur != 0: # 当 high 和 cur 同时为 0 时，说明已经越过最高位，因此跳出
       low += cur * digit # 将 cur 加入 low ，组成下轮 low
       cur = high % 10 # 下轮 cur 是本轮 high 的最低位
       high //= 10 # 将本轮 high 最低位删除，得到下轮 high
       digit *= 10 # 位因子每轮 × 10
    * */
    public int countDigitOne_best(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    private int num_one_count(int i) {
        int count = 0;
        while (i > 0) {
            count += i % 10 == 1 ? 1 : 0;
            i /= 10;
        }
        return count;
    }

    class Solution {
        public int countDigitOne(int n) {
            return f(n);
        }

        private int f(int n) {
            if (n <= 0)
                return 0;
            String s = String.valueOf(n);
            int high = s.charAt(0) - '0';
            int pow = (int) Math.pow(10, s.length() - 1);
            int last = n - high * pow;
            if (high == 1) {
                return f(pow - 1) + last + 1 + f(last);
            } else {
                return pow + high * f(pow - 1) + f(last);
            }
        }
    }
}
