package LeetCode.Easy;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {99};
        System.out.println(new SearchInsert().searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }
}
