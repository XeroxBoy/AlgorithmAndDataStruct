package LeetCode.Medium.DP;

public class FindTargetSumWays {
    private static int way_num = 0;

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1}, 1));
    }

    public int findTargetSumWays(int[] nums, int S) {
        way_num = 0;
        calculateNums(nums, 0, nums[0], S);
        calculateNums(nums, 0, -nums[0], S);
        return way_num;
    }

    public void calculateNums(int[] nums, int startIndex, int now_num, int target) {
        if (startIndex == nums.length - 1) {
            if (now_num == target) {
                way_num++;
            }
            return;
        }
        calculateNums(nums, startIndex + 1, now_num + nums[startIndex + 1], target);
        calculateNums(nums, startIndex + 1, now_num - nums[startIndex + 1], target);
    }

    public static class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int[] dp = new int[2001];
            dp[nums[0] + 1000] = 1;
            dp[-nums[0] + 1000] += 1;
            for (int i = 1; i < nums.length; i++) {
                int[] next = new int[2001];
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[sum + 1000] > 0) {
                        next[sum + nums[i] + 1000] += dp[sum + 1000];
                        next[sum - nums[i] + 1000] += dp[sum + 1000];
                    }
                }
                dp = next;
            }
            return S > 1000 ? 0 : dp[S + 1000];
        }
    }
}
