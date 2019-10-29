package LeetCode.Easy.Array;

public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 12, 0};
        new MoveZero().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void moveZeroes(int[] nums) {
        int numOfZero = 0;
        for (int i = 0; i < nums.length - numOfZero; i++) {
            int isZero = nums[i];
            if (isZero == 0) {
                numOfZero += 1;
                for (int j = i; j < nums.length - numOfZero; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - numOfZero] = 0;
                i -= 1;
            }
        }
    }

    public void greatMoveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
