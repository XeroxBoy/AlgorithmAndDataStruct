package LeetCode.Top100.DP;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new MaxProduct().maxProduct(new int[]{-2, 0, -1}));
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            } //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }
}
