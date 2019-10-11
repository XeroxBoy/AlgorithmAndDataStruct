package LeetCode.Easy.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Rotate {
    public static void main(String[] args) {
        int[] nums = null;
        int k = 3;
        new Rotate().rotate(nums, k);
    }

    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        int[] newNum = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int shouldPlace = (i + k) % nums.length;
            nums[shouldPlace] = newNum[i];
        }

    }
}
