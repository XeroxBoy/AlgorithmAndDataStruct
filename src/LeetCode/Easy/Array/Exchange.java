package LeetCode.Easy.Array;

import java.util.Arrays;

public class Exchange {
    public int[] exchange(int[] nums) {
        int[] copyNums = new int[nums.length];
        int oddIndex = 0;
        int evenIndex = nums.length - 1;
        for (int value : nums) {
            if (value % 2 == 1) copyNums[oddIndex++] = value;
            else copyNums[evenIndex--] = value;
        }
        return copyNums;
    }
}
