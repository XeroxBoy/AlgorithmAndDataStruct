package LeetCode.Easy.Array;

public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] += sum[i - 1] + nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        System.out.println(new NumArray(nums).sumRange(0, 5));
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }
    }
}
