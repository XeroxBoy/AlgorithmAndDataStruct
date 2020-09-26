package LeetCode.Medium.Array;

import java.util.Arrays;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
