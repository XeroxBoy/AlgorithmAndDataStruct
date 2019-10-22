package LeetCode.Easy.Bit;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int differentNum = 0;
        while (x > 0 && y > 0) {
            int lastX = x & 1;
            int lastY = y & 1;
            if (lastX != lastY) differentNum++;
            x >>= 1;
            y >>= 1;
        }
        while (x > 0) {
            int lastX = x & 1;
            if (lastX != 0)
                differentNum++;
            x >>= 1;
        }
        while (y > 0) {
            int lastY = y & 1;
            if (lastY != 0)
                differentNum++;
            y >>= 1;
        }
        return differentNum;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(4, 1));
    }
}

