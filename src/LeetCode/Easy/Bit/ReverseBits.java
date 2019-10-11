package LeetCode.Easy.Bit;

public class ReverseBits {
    public int reverseBits(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a <<= 1;
            a += n & 1;
            n >>= 1;
//            a=a+((1&(n>>i))<<(31-i));
        }
        return a;
//        return Integer.reverse(n);
    }
}
