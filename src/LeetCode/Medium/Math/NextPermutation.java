package LeetCode.Medium.Math;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 7, 5, 3, 2};
//        int[] arr = new int[]{2,3,1};
        new NextPermutation().nextPermutation(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i >= 1) {
            int swapIndex = nums.length - 1;
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[i - 1]) {
                    swapIndex = j;
                    break;
                }
            }
            swap(nums, i - 1, swapIndex);
        }
        reverse(nums, i, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
