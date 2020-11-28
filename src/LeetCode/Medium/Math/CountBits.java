package LeetCode.Medium.Math;

import java.util.Arrays;

public class CountBits {
//    public int[] countBits(int num) {
//        int[] numResult = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            numResult[i] = calculateBitNum(i);
//        }
//        return numResult;
//    }

    public static void main(String[] args) {
        Arrays.stream(new CountBits().countBits(5)).forEach(System.out::println);
    }

    private int calculateBitNum(int data) {
        int bitCnt = 0;
        while (data > 0) {
            bitCnt += data & 1;
            data >>= 1;
        }
        return bitCnt;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i)
                ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
            return ans;
        }
    }
}
