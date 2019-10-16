package LeetCode.Easy.Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int maxDistance = k+1;
            int compareNum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == compareNum){
                    maxDistance = j - i;
                }
                if(maxDistance <= k) return true;
            }
        }
        return false;
    }
    public boolean mapContainsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int index = map.get(nums[i]);
                if (Math.abs(index - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,1,2,3};
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(array,3));
    }
}

