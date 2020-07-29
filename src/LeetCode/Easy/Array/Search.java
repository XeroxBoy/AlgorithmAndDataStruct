package LeetCode.Easy.Array;

public class Search {
    public int search(int[] nums, int target) {
        int appear_times = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && target == nums[i]) {
                appear_times++;
                i++;
            }
        }
        return appear_times;
    }

    class Solution {
        public int search(int[] nums, int target) {
            return helper(nums, target) - helper(nums, target - 1);
        }

        int helper(int[] nums, int tar) {
            int i = 0, j = nums.length - 1;
            while (i <= j) {
                int m = (i + j) / 2;
                if (nums[m] <= tar) i = m + 1;
                else j = m - 1;
            }
            return i;
        }
    }

}
