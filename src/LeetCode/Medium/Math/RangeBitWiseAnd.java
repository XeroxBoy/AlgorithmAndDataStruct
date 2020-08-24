package LeetCode.Medium.Math;

public class RangeBitWiseAnd {
    public static void main(String[] args) {
        System.out.println(new RangeBitWiseAnd().rangeBitwiseAnd(0, 1));
        System.out.println(new RangeBitWiseAnd().rangeBitwiseAnd(5, 7));
        System.out.println(new RangeBitWiseAnd().rangeBitwiseAnd(0, Integer.MAX_VALUE));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift += 1;
        }
        return m << shift;
    }

    private int andByBit(int a, int b) {
        int ander = 1;
        while (ander < a && ander < b) {
            int tempAnder = ander;
//            int andBit = (a & 1)
        }
        return 0;
    }
}
