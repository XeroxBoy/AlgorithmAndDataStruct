package LeetCode.Easy.DP;

public class MaxSubArrayⅡ {
    public static void main(String[] args) {
        System.out.println(new MaxSubArrayⅡ().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max_result = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max_result = Math.max(max_result, dp[i]);
        }
        return max_result;
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] += Math.max(nums[i - 1], 0);
                res = Math.max(res, nums[i]);
            }
            return res;
        }
    }
}
