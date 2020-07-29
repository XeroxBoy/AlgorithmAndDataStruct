package LeetCode.Easy.Array;

import java.util.HashMap;

public class TwoSumⅢ {
    public int[] twoSum(int[] nums, int target) {
        int[] map = new int[target];
        for (int num : nums) {
            if (num >= target) break;
            if (map[num] == 0)
                map[target - num] = num;
            else
                return new int[]{target - num, num};
        }
        return new int[2];
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int s = nums[i] + nums[j];
                if (s < target) i++;
                else if (s > target) j--;
                else return new int[]{nums[i], nums[j]};
            }
            return new int[0];
        }
    }

}
