package LeetCode.Medium.DP;

import java.util.HashMap;
import java.util.Map;

public class checksubArraySum {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new checksubArraySum().checkSubarraySum_simpleDP(new int[]{0, 1, 0}, 0));
//        System.out.println(new checksubArraySum().checkSubArraySum_Hashmap(new int[]{0,1,0},0));
//        System.out.println(new checksubArraySum().checkSubArraySum_Hashmap(new int[]{0,0},0));
//        System.out.println(new checksubArraySum().checkSubArraySum_Hashmap(new int[]{0,1,0,3,0,4,0,4,0
//        },5));
//        System.out.println(new checksubArraySum().checkSubarraySum(new int[]{0,0},0));
//        System.out.println(new checksubArraySum().checkSubarraySum(new int[]{0,1,0,3,0,4,0,4,0
//        },5));
        System.out.println(new checksubArraySum().checkSubarraySum(new int[]{5, 2, 4
        }, 6));
    }

    public boolean checkSubarraySum_simpleDP(int[] nums, int k) {
        //记忆化搜索法
        int[] sums = new int[nums.length];
        if (nums.length != 0)
            sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i];
        }
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                int subSum = sums[j] - sums[i] + nums[i];
                if ((k != 0 && subSum % k == 0) || subSum == k)
                    return true;
            }
        }
        return false;
    }

    public boolean checkSubArraySum_Hashmap(int[] nums, int k) {
        int[] sums = new int[nums.length];
        if (nums.length == 0) return false;
        map.put(0, -1);
        sums[0] = nums[0];
        if (k != 0)
            sums[0] = sums[0] % k;
        if (!map.containsKey(sums[0]))
            map.put(sums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
            if (k != 0)
                sums[i] = sums[i] % k;
            if (map.containsKey(sums[i])) {
                if (i - map.get(sums[i]) > 1)
                    return true;
            } else
                map.put(sums[i], i);
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}
