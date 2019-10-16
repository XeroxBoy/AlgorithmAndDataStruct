package LeetCode.Easy.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(nums[i])){return true;}
            numMap.put(nums[i],1);
        }
        return false;
    }
    public boolean setContainsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<Integer>();
        for(int i:nums)
            res.add(i);
        return res.size() < nums.length;
    }
}

