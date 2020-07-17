package LeetCode.Easy.Array;

public class SearchInsertⅡ {
    public static void main(String[] args) {
        System.out.println(new SearchInsertⅡ().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new SearchInsertⅡ().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertⅡ().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertⅡ().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(
                new SearchInsertⅡ().searchInsert(new int[]{1, 3}, 3)
        );
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;

        }
        return nums.length;
    }
}
