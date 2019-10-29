package LeetCode.Easy.Array;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] array = {3, 0, 1};
        new MissingNumber().missingNumber(array);
    }

    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums[nums.length - 1] + 1;
    }

    public int greatMissingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }
}
