package LeetCode.Easy;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3};
        System.out.println(new RemoveElement().removeElement(nums, 3));
    }

    public int removeElement(int[] nums, int val) {
        int valFlag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[valFlag++] = nums[i];
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != val) {
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
