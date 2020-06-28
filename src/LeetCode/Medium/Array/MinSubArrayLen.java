package LeetCode.Medium.Array;

import java.util.Arrays;

public class MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new MinSubArrayLen().otherMinSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int otherMinSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(j - i + 1, len);
                sum -= nums[i++];
            }
        }
        return len;
    }

    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int[] sums = new int[n + 1];
            // 为了方便计算，令 size = n + 1
            // sums[0] = 0 意味着前 0 个元素的前缀和为 0
            // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
            // 以此类推
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                int target = s + sums[i - 1];
                int bound = Arrays.binarySearch(sums, target);
                if (bound < 0) {
                    bound = -bound - 1;
                }
                if (bound <= n) {
                    ans = Math.min(ans, bound - (i - 1));
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
