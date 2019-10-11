package LeetCode.Easy.Bit;

public class HammingWeight {
    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;
            n >>= 1;
            sum = lastBit == 1 ? sum + 1 : sum;
        }
        return sum;
    }

}
