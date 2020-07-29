package LeetCode.Medium.Array;


public class SingleNumbers {
    public static void main(String[] args) {
        int[] results = new SingleNumbers().singleNumbers(new int[]{1, 2, 5, 2});
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public int[] singleNumbers(int[] nums) {
        int orNum = 0;
        for (int num : nums) {
            orNum ^= num;
        }
        int div = 1;
        while ((div & orNum) == 0) div <<= 1;
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((div & nums[i]) == 0) a ^= nums[i];
            else b ^= nums[i];
        }
        return new int[]{a, b};
    }
}
