package LeetCode.Easy.Bit;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(2));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(4));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(8));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(15));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(218));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n != 0) {
            if (n == 1) return true;
            int lastBit = n & 1;
            if (lastBit == 1) return false;
            n >>= 1;
        }
        return true;
    }
}
