package LeetCode.Easy.Array;

import java.util.Arrays;

public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(new FindRepeatNumber().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(new FindRepeatNumber().findRepeatNumber(new int[]{3, 1, 2, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        int index = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                index = pre;
                break;
            }
            pre = nums[i];
        }
        return index;
    }
}
