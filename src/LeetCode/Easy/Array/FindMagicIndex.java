package LeetCode.Easy.Array;

public class FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }
}
