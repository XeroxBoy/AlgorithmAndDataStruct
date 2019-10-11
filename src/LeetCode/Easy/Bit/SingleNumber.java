package LeetCode.Easy.Bit;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new SingleNumber().singleNumber(nums));
        System.out.println(new SingleNumber().greatSingleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, 2);
            }
        }
        Set<Integer> keySet = map.keySet();
        int keyV = -1;
        for (Integer key : keySet) {
            if (map.get(key).equals(1)) keyV = key;
        }
        return keyV;
    }

    public int greatSingleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}
