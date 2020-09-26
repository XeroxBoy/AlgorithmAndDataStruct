package LeetCode.Medium.Array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sum = Arrays.stream(nums).reduce(1, (value, item) -> value * item);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        result[i] *= nums[j];
                    }
                }
            } else
                result[i] = sum / nums[i];
        }
        return result;
    }
}
