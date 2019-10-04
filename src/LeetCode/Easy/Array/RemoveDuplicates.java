package LeetCode.Easy.Array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int valFlag = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (i > 0 && val != nums[i - 1]) {
                nums[valFlag++] = nums[i];
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == val) continue;
                else {
                    nums[valFlag++] = nums[j];
                    i = j;
                    break;
                }
            }
        }
        for (int i = 0; i < valFlag; i++) {
            System.out.println(nums[i]);
        }
        return valFlag;
    }
}
