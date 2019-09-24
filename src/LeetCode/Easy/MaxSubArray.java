package LeetCode.Easy;

public class MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-1, 2, 3, 11};
        System.out.println(new MaxSubArray().maxSubArray(nums));
        System.out.println(new MaxSubArray().greatMaxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int allMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
            if (max > allMax) {
                allMax = max;
            }
        }
        return allMax;
    }

    public int greatMaxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0)//昨天赢钱 记住他
                sum += nums[i];
            else //昨天亏钱 忘了他
                sum = nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
