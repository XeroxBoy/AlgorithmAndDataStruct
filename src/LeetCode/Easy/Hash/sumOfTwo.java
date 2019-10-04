package LeetCode.Easy.Hash;

import java.util.HashMap;

public class sumOfTwo {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 6, 7};
        System.out.println(new sumOfTwo().twoSum(nums, 9)[1] + " " + new sumOfTwo().twoSum(nums, 9)[0]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                }
            }
            if (flag) break;
        }
        return result;
    }

    public int[] twoSumGreat(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        // // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        return indexs;
    }

}
