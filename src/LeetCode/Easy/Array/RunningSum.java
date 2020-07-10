package LeetCode.Easy.Array;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        Arrays.stream(new RunningSum().runningSum(new int[]{1, 2, 3, 4})).forEach(System.out::println);
        Arrays.stream(new RunningSum().runningSum(new int[]{1})).forEach(System.out::println);
    }

    public int[] runningSum(int[] nums) {
        if (nums.length <= 1) return nums;
        int[] results = new int[nums.length];
        results[0] = nums[0];
        for (int i = 1; i < results.length; i++) {
            results[i] = nums[i] + results[i - 1];
        }
        return results;
    }
}
