package LeetCode.Easy.Bit;

public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int oneNum = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if (bits[i] == 0) {
                int j = i - 1;
                while (j >= 0 && bits[j--] == 1)
                    oneNum++;
                break;
            }
        }
        return oneNum % 2 == 0;
    }
}
