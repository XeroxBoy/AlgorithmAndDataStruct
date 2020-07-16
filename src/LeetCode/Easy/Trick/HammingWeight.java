package LeetCode.Easy.Trick;

public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(4));
        System.out.println(new HammingWeight().hammingWeight(1));
//        System.out.println(new HammingWeight().hammingWeight(4294967293));

    }

    public int hammingWeight(int n) {
        System.out.println(n);
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            n >>>= 1; //无符号右移
        }
        return sum;
    }

    public class Solution {
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                res++;
                n &= n - 1;//从右往左消去1为0
            }
            return res;
        }
    }
}
