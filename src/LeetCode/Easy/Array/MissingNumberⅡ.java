package LeetCode.Easy.Array;

public class MissingNumberⅡ {
    public int missingNumber(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
            index = i;
        }
        return index + 1;
    }
}
