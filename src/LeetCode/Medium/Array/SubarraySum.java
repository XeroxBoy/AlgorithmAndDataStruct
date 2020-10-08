package LeetCode.Medium.Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int j = i;
            if (sum == k) subArrayCount++;
            while (j + 1 < nums.length) {
                sum += nums[j + 1];
                j += 1;
                if (sum == k) subArrayCount++;
            }
        }
        return subArrayCount;
    }

    public class Solution {

        public int subarraySum(int[] nums, int k) {
            /**
             扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
             **/
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0, ret = 0;

            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    ret += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return ret;
        }
    }

}
