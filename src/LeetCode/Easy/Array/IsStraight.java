package LeetCode.Easy.Array;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class IsStraight {
    public static void main(String[] args) {
        System.out.println(new IsStraight().isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(new IsStraight().isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new IsStraight().isStraight(new int[]{0, 0, 8, 5, 4}));
    }

    public boolean isStraight(int[] nums) {
        int zeroCount = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num != 0) break;
            zeroCount++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 || nums
                    [i - 1] == 0) continue;
            if (nums[i] - nums[i - 1] != 1) {
                int distance = Math.abs(nums[i] - nums[i - 1]);
                if (distance == 0) return false;
                if (distance > zeroCount + 1)
                    return false;
                else {
                    zeroCount -= distance - 1;
                }
            }
        }
        return true;
    }
}
