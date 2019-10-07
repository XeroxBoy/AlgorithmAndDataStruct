package LeetCode.Easy.DP;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums1 = {3, 2, 3};
        System.out.println(new MajorityElement().majorityElement(nums1));
    }

    public int majorityElement(int[] nums) {
        int major = nums[0];
        int times = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                times++;
            } else {
                times--;
                if (times == 0) {
                    major = nums[i];
                    times = 1;
                }
            }
        }
        return major;
    }
}
