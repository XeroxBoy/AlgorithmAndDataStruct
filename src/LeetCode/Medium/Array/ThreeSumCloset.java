package LeetCode.Medium.Array;

import java.util.Arrays;

public class ThreeSumCloset {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new ThreeSumCloset().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int minDistance = Math.abs(sum - target);
        int result = sum;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int tempSum = nums[start] + nums[end] + nums[i];
                if (Math.abs(tempSum - target) < minDistance) {
                    minDistance = Math.abs(tempSum - target);
                    result = tempSum;
                }
                if (tempSum < target) start++;
                else if (tempSum > target) end--;
                else return tempSum;
            }
        }
        return result;
    }
}
